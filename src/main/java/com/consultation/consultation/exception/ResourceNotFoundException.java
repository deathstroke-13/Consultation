package com.consultation.consultation.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{

    public String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
