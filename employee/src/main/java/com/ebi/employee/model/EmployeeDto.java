package com.ebi.employee.model;

public class EmployeeDto {
    private int id;
    private String firstName;
    private String secondName;
    private String salary;

    public EmployeeDto() { }

    public EmployeeDto(int id, String firstName, String secondName, String salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
