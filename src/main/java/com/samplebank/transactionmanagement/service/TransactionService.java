package com.samplebank.transactionmanagement.service;

import com.samplebank.transactionmanagement.model.Transaction;
import com.samplebank.transactionmanagement.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void create(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getByAccountId(UUID accountId) {
        return transactionRepository.getByAccountId(accountId);
    }
}
