package com.samplebank.transactionmanagement.model;

import com.samplebank.transactionmanagement.enums.OperationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transaction_operation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "is null")
    private UUID accountId;

    @NotNull(message = "is null")
    private OperationType operationType;

    @NotNull(message = "is null")
    @Min(value = 0, message = "is less than 0")
    private BigDecimal amount;
}
