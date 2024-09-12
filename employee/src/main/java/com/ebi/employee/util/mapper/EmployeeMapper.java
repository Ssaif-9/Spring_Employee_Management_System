package com.ebi.employee.util.mapper;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDto fromEmployeeEntityToEmployeeDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setSalary(employeeEntity.getSalary());
        return employeeDto;
    }

    public static EmployeeEntity fromEmployeeDtoToEmployeeEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setSalary(employeeDto.getSalary());
        return employeeEntity;
    }
}
