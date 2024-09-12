package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;

import java.util.List;

public interface EmployeeServiceInterface {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeSaveDto saveEmployee(EmployeeSaveDto employee);

    EmployeeSaveDto updateEmployee(EmployeeSaveDto employee);

    EmployeeSaveDto patchUpdateEmployee(EmployeeSaveDto employee);

    EmployeeDto getEmbloyeeByNameAndMail(String name, String mail);

    void deleteEmployee(long id);
}
