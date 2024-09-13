package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;

import java.util.List;

public interface EmployeeServiceInterface {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto saveEmployee(EmployeeSaveDto employee);

    EmployeeDto updateEmployee(EmployeeSaveDto employee);

    EmployeeDto patchUpdateEmployee(EmployeeSaveDto employee);

    EmployeeDto getEmployeeByNameAndMail(String name, String mail);

    EmployeeDto deleteEmployee(Long id);
}
