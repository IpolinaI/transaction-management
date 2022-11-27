package com.samplebank.transactionmanagement.dto;

import com.samplebank.transactionmanagement.enums.OperationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class TransactionRequestDTO {

    private UUID accountId;

    private OperationType operationType;

    private BigDecimal amount;
}
