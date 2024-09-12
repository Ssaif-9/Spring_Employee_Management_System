package com.ebi.employee.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeSaveDto {
    private Long id;
    private String name;
    private String salary;
    private String email;
    private String phone;
    private String address;
}

