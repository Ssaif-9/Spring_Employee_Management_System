package com.ebi.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {


    /*
     * For Search Employee By ID
     * Check if ID Exist or not
     * */
    @ExceptionHandler(value = CustomException.class)
    ErrorException getEmployeeByIdExceptionHandler(CustomException employeeGetException) {
        ErrorException errorException = new ErrorException(employeeGetException.getExceptionCode(), employeeGetException.getExceptionMessage(), employeeGetException.getExceptionDetail(),employeeGetException.getHttpStatus());
        return errorException;
    }

//    @ExceptionHandler(value = {Exception.class})
//    ResponseEntity<?> handleAnyException(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
}
