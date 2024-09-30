package com.ebi.employee.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {


    @ExceptionHandler(value = CustomException.class)
    ErrorException getEmployeeByIdExceptionHandler(CustomException employeeGetException) {
        ErrorException errorException = new ErrorException(employeeGetException.getExceptionCode(), employeeGetException.getExceptionMessage(), employeeGetException.getExceptionDetail(),employeeGetException.getExceptionhttpStatus());
        return errorException;
    }

//    @ExceptionHandler(value = {Exception.class})
//    ResponseEntity<?> handleAnyException(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
}
