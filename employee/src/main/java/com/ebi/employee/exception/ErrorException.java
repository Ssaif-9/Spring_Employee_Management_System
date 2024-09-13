package com.ebi.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorException {
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetail;
}
