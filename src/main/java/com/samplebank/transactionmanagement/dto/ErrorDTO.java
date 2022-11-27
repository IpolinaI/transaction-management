package com.samplebank.transactionmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private Object context;
}
