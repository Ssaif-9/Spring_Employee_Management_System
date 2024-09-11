package com.ebi.employee.repo;

import com.ebi.employee.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepoInterface {

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(int id);

    EmployeeEntity saveEmployee(EmployeeEntity employee);

    EmployeeEntity updateEmployee(EmployeeEntity employee, int id);

    EmployeeEntity patchUpdateEmployee(EmployeeEntity employee, int id);

    boolean deleteEmployee(int id);

}
