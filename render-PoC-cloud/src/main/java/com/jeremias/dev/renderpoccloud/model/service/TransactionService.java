package com.jeremias.dev.renderpoccloud.model.service;

import com.jeremias.dev.renderpoccloud.model.entity.Transaction;
import com.jeremias.dev.renderpoccloud.model.exception.TransactionException;
import com.jeremias.dev.renderpoccloud.model.repository.TransactionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(final Transaction transaction) throws TransactionException {
        if (transaction == null) {
            throw new TransactionException("The transaction is null");
        }

        if (transaction.getId() != null) {
            throw new TransactionException("The transaction id is not null");
        }

        if (StringUtils.isBlank(transaction.getDescription())) {
            throw new TransactionException("The transaction description is blank");
        }

        transaction.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public Transaction update(final Transaction transaction) throws TransactionException {
        if (transaction == null) {
            throw new TransactionException("The transaction is null");
        }

        if (transaction.getId() == null) {
            throw new TransactionException("The transaction id is null");
        }

        if (StringUtils.isBlank(transaction.getDescription())) {
            throw new TransactionException("The transaction description is blank");
        }

        if (!transactionRepository.existsById(transaction.getId())) {
            throw new TransactionException("The transaction id does not exist: " + transaction.getId());
        }

        transaction.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(final UUID uuid) {
        return transactionRepository.findById(uuid);
    }
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAllOrderByCreatedAtDesc();
    }
    public void deleteById(final UUID uuid) throws TransactionException {
        if (uuid == null) {
            throw new TransactionException("The transaction is null");
        }

        if (!transactionRepository.existsById(uuid)) {
            throw new TransactionException("The transaction id does not exist: " + uuid);
        }

        transactionRepository.deleteById(uuid);
    }

    public Double getCurrentBalance() {
        return transactionRepository.sumByAmount();
    }
}
