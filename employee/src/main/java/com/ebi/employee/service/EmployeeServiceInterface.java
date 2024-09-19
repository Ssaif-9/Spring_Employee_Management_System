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

    List<EmployeeSaveDto> getEmployeeBySalary(String salary);

    List<EmployeeSaveDto> getEmployeeByGraterSalary(String salary);

    List<EmployeeSaveDto> getEmployeeByLessSalary(String salary);

    EmployeeDto deleteEmployee(Long id);

    String loginEmployee(String email, String phone);
}
