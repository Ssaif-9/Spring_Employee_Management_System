package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;

import java.util.List;

public interface EmployeeServiceInterface {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(long id);

    EmployeeSaveDto saveEmployee(EmployeeSaveDto employee);

    EmployeeSaveDto updateEmployee(EmployeeSaveDto employee);

    EmployeeSaveDto patchUpdateEmployee(EmployeeSaveDto employee);

    void deleteEmployee(long id);
}
