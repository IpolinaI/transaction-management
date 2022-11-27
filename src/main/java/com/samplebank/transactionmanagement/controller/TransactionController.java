package com.samplebank.transactionmanagement.controller;

import com.samplebank.transactionmanagement.dto.TransactionRequestDTO;
import com.samplebank.transactionmanagement.dto.TransactionResponseDTO;
import com.samplebank.transactionmanagement.mapper.TransactionMapper;
import com.samplebank.transactionmanagement.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction-management/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        transactionService.create(transactionMapper.map(transactionRequestDTO));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionResponseDTO>> getByAccountId(@PathVariable("accountId") UUID accountId) {
        List<TransactionResponseDTO> transactionResponseDTOs =
                transactionMapper.map(transactionService.getByAccountId(accountId));

        return new ResponseEntity<>(transactionResponseDTOs, HttpStatus.OK);
    }
}
