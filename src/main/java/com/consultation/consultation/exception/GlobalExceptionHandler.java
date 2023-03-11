package com.consultation.consultation.exception;

import com.consultation.consultation.dto.BaseResponseJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotAcceptableException.class)
    public ResponseEntity<BaseResponseJson> notAcceptable(ResourceNotAcceptableException ex) {
        BaseResponseJson base = settingMap(ex.getMessage());
        return new ResponseEntity<>(base, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponseJson> notFoundException(ResourceNotFoundException ex){
        BaseResponseJson base = settingMap(ex.getMessage());
        return new ResponseEntity<>(base, HttpStatus.NOT_FOUND);
    }

    public BaseResponseJson settingMap(String exceptionMessage){
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(exceptionMessage);
        base.setData("Timestamp : " + LocalDateTime.now());
        return base;
    }
}