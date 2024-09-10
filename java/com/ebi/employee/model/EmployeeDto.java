package com.ebi.employee.model;

public class EmployeeDto {
   private Long employeeId;
    private String employeeName;
    private  String employeeSurname;

    public EmployeeDto() { }

    public EmployeeDto(Long employeeId, String employeeName, String employeeSurname) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
}
