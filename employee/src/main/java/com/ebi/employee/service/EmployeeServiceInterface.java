package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {

    List<EmployeeSaveDto> getAllEmployees();

    EmployeeSaveDto getEmployeeById(Long id);

    EmployeeDto saveEmployee(EmployeeSaveDto employee);

    EmployeeDto updateEmployee(EmployeeSaveDto employee);

    EmployeeDto patchUpdateEmployee(EmployeeSaveDto employee);

    List<EmployeeSaveDto> getEmployeeByName(String name);

    List<EmployeeSaveDto> getEmployeeByEmail(String email) ;

    List<EmployeeSaveDto> getEmployeeByPhone(String phone);

    EmployeeDto deleteEmployee(Long id);

    EmployeeDto loginEmployee(String email, String phone);
}
