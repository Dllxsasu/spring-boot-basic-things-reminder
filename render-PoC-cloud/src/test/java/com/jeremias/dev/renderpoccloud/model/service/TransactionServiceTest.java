package com.jeremias.dev.renderpoccloud.model.service;

import com.jeremias.dev.renderpoccloud.model.entity.Transaction;
import com.jeremias.dev.renderpoccloud.model.exception.TransactionException;
import com.jeremias.dev.renderpoccloud.model.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    /*
    *GIVEN: a null transaction
    * WHEN: create
    * THEN: transactionException
     */
    @Test
    public void givenNullTransactionWhenCreateThenTransactionException(){
        assertThrows(TransactionException.class, () -> transactionService.create(null));
    }

    /*
    *GIVEN: a transaction with id
    *WHEN: create
    *THEN: TransactionException
     */
    @Test
    void givenIdWhenCreateThenTransactionException(){
        final var transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        assertThrows(TransactionException.class, () -> transactionService.create(transaction));
    }

    /*
    *GIVEN: a transaction with blanck description
    * WHEN: create
    * THEN: TransactionException
    */
    @Test
    void givenBlankDescriptionWhenCreateThenTransactionException() {
        final var transaction = new Transaction();
        transaction.setDescription("");

        assertThrows(TransactionException.class, () -> transactionService.create(transaction));
    }

    /**
     * GIVEN: a valid transaction
     * WHEN: create
     * THEN: successful
     *
     * @throws TransactionException if an error occurs
     */

    @Test
    void givenValidTransactionWhenCreateThenSuccessful() throws TransactionException {
        doAnswer(invocation -> {
            final var transaction = invocation.getArgument(0, Transaction.class);
            transaction.setId(UUID.randomUUID());
            return transaction;
        }).when(transactionRepository).save(Mockito.any(Transaction.class));

        final var transaction = new Transaction();
        transaction.setAmount(20.50);
        transaction.setDescription("description");

        final var result = transactionService.create(transaction);

        assertNotNull(result.getId());
            assertNotNull(result.getCreatedAt());
        assertEquals(transaction.getAmount(), result.getAmount());
        assertEquals(transaction.getDescription(), result.getDescription());

        verify(transactionRepository,times(1)).save(Mockito.any(Transaction.class));
    }

    /**
     * GIVEN: a null transaction
     * WHEN: update
     * THEN: TransactionException
     */
    @Test
    void givenNullTransactionWhenUpdateThenTransactionException() {
        assertThrows(TransactionException.class, () -> transactionService.update(null));
    }

    /**
     * GIVEN: a transaction with null id
     * WHEN: update
     * THEN: TransactionException
     */
    @Test
    void givenNullIdWhenUpdateThenTransactionException() {
        assertThrows(TransactionException.class, () -> transactionService.update(new Transaction()));
    }

    /**
     * GIVEN: a transaction with blank description
     * WHEN: update
     * THEN: TransactionException
     */
    @Test
    void givenBlankDescriptionWhenUpdateThenTransactionException() {
        final var transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setDescription("");

        assertThrows(TransactionException.class, () -> transactionService.update(transaction));
    }

    /**
     * GIVEN: a transaction with no existing id
     * WHEN: update
     * THEN: TransactionException
     */
    @Test
    void givenNoExistingIdWhenUpdateThenTransactionException() {
        doReturn(false).when(transactionRepository).existsById(Mockito.any(UUID.class));

        final var transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setDescription("description");

        assertThrows(TransactionException.class, () -> transactionService.update(transaction));

        verify(transactionRepository).existsById(Mockito.any(UUID.class));
    }

    /**
     * GIVEN: a valid transaction
     * WHEN: update
     * THEN: successful
     *
     * @throws TransactionException if an error occurs
     */
    @Test
    void givenValidTransactionWhenUpdateThenSuccessful() throws TransactionException {
        doReturn(true).when(transactionRepository).existsById(Mockito.any(UUID.class));
        doAnswer(invocation -> invocation.getArgument(0, Transaction.class))
                .when(transactionRepository).save(Mockito.any(Transaction.class));

        final var transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setAmount(20.50);
        transaction.setDescription("description");

        final var result = transactionService.update(transaction);

        assertEquals(transaction.getId(), result.getId());
        assertNotNull(result.getCreatedAt());
        assertEquals(transaction.getAmount(), result.getAmount());
        assertEquals(transaction.getDescription(), result.getDescription());

        verify(transactionRepository).existsById(Mockito.any(UUID.class));
        verify(transactionRepository).save(Mockito.any(Transaction.class));
    }
    /**
     * GIVEN: a valid id
     * WHEN: findById
     * THEN: successful
     */
    @Test
    void givenIdWhenFindByIdThenSuccessful() {
        doAnswer(invocation -> Optional.of(new Transaction(invocation.getArgument(0, UUID.class),
                LocalDateTime.now(), 20.50, "description")))
                .when(transactionRepository).findById(Mockito.any(UUID.class));

        final var uuid = UUID.randomUUID();
        final var result = transactionService.findById(uuid);

        assertTrue(result.isPresent());
        assertEquals(uuid, result.get().getId());
        assertNotNull(result.get().getCreatedAt());
        assertEquals(20.50, result.get().getAmount());
        assertEquals("description", result.get().getDescription());

        verify(transactionRepository).findById(Mockito.any(UUID.class));
    }


}