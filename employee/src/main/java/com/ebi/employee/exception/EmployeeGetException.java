package com.ebi.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeGetException extends RuntimeException {
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetail;
}
