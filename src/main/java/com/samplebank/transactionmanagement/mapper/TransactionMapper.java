package com.samplebank.transactionmanagement.mapper;

import com.samplebank.transactionmanagement.dto.TransactionRequestDTO;
import com.samplebank.transactionmanagement.dto.TransactionResponseDTO;
import com.samplebank.transactionmanagement.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "id", ignore = true)
    Transaction map(TransactionRequestDTO transactionRequestDTO);

    TransactionResponseDTO map(Transaction transaction);

    List<TransactionResponseDTO> map(List<Transaction> transaction);
}
