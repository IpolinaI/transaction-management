package com.samplebank.transactionmanagement.mapper;

import com.samplebank.transactionmanagement.dto.TransactionRequestDTO;
import com.samplebank.transactionmanagement.dto.TransactionResponseDTO;
import com.samplebank.transactionmanagement.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T20:44:07+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction map(TransactionRequestDTO transactionRequestDTO) {
        if ( transactionRequestDTO == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.accountId( transactionRequestDTO.getAccountId() );
        transaction.operationType( transactionRequestDTO.getOperationType() );
        transaction.amount( transactionRequestDTO.getAmount() );

        return transaction.build();
    }

    @Override
    public TransactionResponseDTO map(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();

        transactionResponseDTO.setId( transaction.getId() );
        transactionResponseDTO.setAccountId( transaction.getAccountId() );
        transactionResponseDTO.setOperationType( transaction.getOperationType() );
        transactionResponseDTO.setAmount( transaction.getAmount() );

        return transactionResponseDTO;
    }

    @Override
    public List<TransactionResponseDTO> map(List<Transaction> transaction) {
        if ( transaction == null ) {
            return null;
        }

        List<TransactionResponseDTO> list = new ArrayList<TransactionResponseDTO>( transaction.size() );
        for ( Transaction transaction1 : transaction ) {
            list.add( map( transaction1 ) );
        }

        return list;
    }
}
