package com.jeremias.dev.renderpoccloud.model.repository;

import com.jeremias.dev.renderpoccloud.model.entity.Transaction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    default Iterable<Transaction> findAllOrderByCreatedAtDesc() {
        return findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @Transactional(readOnly = true)
    @Query("SELECT SUM(t.amount) FROM Transaction t")
    Double sumByAmount();
}
