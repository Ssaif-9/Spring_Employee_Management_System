package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeServiceInterface {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(int id);

    EmployeeDto saveEmployee(EmployeeDto employee);

    EmployeeDto updateEmployee(EmployeeDto employee, int id);

    EmployeeDto patchUpdateEmployee(EmployeeDto employee, int id);

    boolean deleteEmployee(int id);
}
