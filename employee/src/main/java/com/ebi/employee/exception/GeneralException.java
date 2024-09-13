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
    @ExceptionHandler(value = EmployeeGetException.class)
    ResponseEntity<?> getEmployeeByIdExceptionHandler(EmployeeGetException employeeGetException) {
        ErrorException errorException = new ErrorException(employeeGetException.getExceptionCode(), employeeGetException.getExceptionMessage(), employeeGetException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }
    /*
    * For Save Employee
    * Check if number include 11 digit and start with 01
    * check if Email has @ and .com
    * */
    @ExceptionHandler(value = EmployeeSaveException.class)
    ResponseEntity<?> saveEmployeeExceptionHandler(EmployeeSaveException employeeSaveException) {
        ErrorException errorException = new ErrorException(employeeSaveException.getExceptionCode(), employeeSaveException.getExceptionMessage(), employeeSaveException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }

    /*
     * For Update Employee
     * make sure all field has valid data (no null field)
     * */
    @ExceptionHandler(value = EmployeeUpdateException.class)
    ResponseEntity<?> updateEmployeeExceptionHandler(EmployeeUpdateException employeeUpdateException) {
        ErrorException errorException = new ErrorException(employeeUpdateException.getExceptionCode(), employeeUpdateException.getExceptionMessage(), employeeUpdateException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }

    /*
     * For Delete Employee By ID
     * Check if ID Exist or not
     * */
    @ExceptionHandler(value = EmployeeDeleteException.class)
    ResponseEntity<?> deleteEmployeeExceptionHandler(EmployeeDeleteException employeeDeleteException) {
        ErrorException errorException = new ErrorException(employeeDeleteException.getExceptionCode(), employeeDeleteException.getExceptionMessage(), employeeDeleteException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = CustomException.class)
    ResponseEntity<?> deleteEmployeeExceptionHandler(CustomException customException) {
        ErrorException errorException = new ErrorException(customException.getExceptionCode(), customException.getExceptionMessage(), customException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = {Exception.class})
//    ResponseEntity<?> handleAnyException(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
}
