package com.ebi.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {

    @ExceptionHandler(value = CustomException.class)
    ResponseEntity<?> customExceptionHandler(CustomException customException) {
        ErrorException errorException = new ErrorException(customException.getExceptionCode(),customException.getExceptionMessage(),customException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<?> handleAnyException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
