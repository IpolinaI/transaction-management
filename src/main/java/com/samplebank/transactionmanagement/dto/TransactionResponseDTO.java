package com.samplebank.transactionmanagement.dto;

import com.samplebank.transactionmanagement.enums.OperationType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionResponseDTO {

    private UUID id;

    private UUID accountId;

    private OperationType operationType;

    private BigDecimal amount;
}
