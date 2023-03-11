package com.consultation.consultation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceNotAcceptableException extends RuntimeException{

    private final String message;

    public ResourceNotAcceptableException(String message) {
        this.message = message;
    }
}
