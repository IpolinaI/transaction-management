package com.samplebank.transactionmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samplebank.transactionmanagement.dto.TransactionRequestDTO;
import com.samplebank.transactionmanagement.enums.OperationType;
import com.samplebank.transactionmanagement.model.Transaction;
import com.samplebank.transactionmanagement.repository.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void afterEach() {
        transactionRepository.deleteAll();
    }

    @Test
    void createWhenRequestIsValidReturnsCreatedStatus() throws Exception {
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
                .accountId(UUID.randomUUID())
                .operationType(OperationType.WITHDRAWAL)
                .amount(BigDecimal.TEN)
                .build();
        mockMvc.perform(post("/transaction-management/api/transactions")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(transactionRequestDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void createWhenRequestIsNotValidReturnsBadRequestStatus() throws Exception {
        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
                .accountId(UUID.randomUUID())
                .operationType(OperationType.WITHDRAWAL)
                .amount(BigDecimal.valueOf(-10))
                .build();
        mockMvc.perform(post("/transaction-management/api/transactions")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(transactionRequestDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getReturnsExpectedResult() throws Exception {
        Transaction transaction = transactionRepository.save(Transaction.builder()
                .accountId(UUID.randomUUID())
                .amount(BigDecimal.ONE)
                .operationType(OperationType.WITHDRAWAL).build());

        mockMvc.perform(get("/transaction-management/api/transactions/{accountId}", transaction.getAccountId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(transaction.getId().toString()))
                .andExpect(jsonPath("$[0].accountId").value(transaction.getAccountId().toString()))
                .andExpect(jsonPath("$[0].operationType").value(OperationType.WITHDRAWAL.toString()))
                .andExpect(jsonPath("$[0].amount").value("1.0"));
    }
}
