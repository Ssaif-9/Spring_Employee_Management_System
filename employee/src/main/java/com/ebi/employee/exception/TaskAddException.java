package com.ebi.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TaskAddException extends RuntimeException{
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetail;
}
