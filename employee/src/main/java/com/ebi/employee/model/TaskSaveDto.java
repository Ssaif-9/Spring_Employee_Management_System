package com.ebi.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskSaveDto {
    private Long id;
    private String name;
    private String description;
    private String date;
    private Long employeeId;
}
