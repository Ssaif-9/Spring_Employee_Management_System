package com.ebi.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSaveException extends RuntimeException{
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetail;

}
