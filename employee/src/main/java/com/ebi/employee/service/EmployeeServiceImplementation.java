package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.entity.EmployeeEntity;
import com.ebi.employee.repo.EmployeeRepoInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.ebi.employee.util.mapper.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements  EmployeeServiceInterface{

    private final EmployeeRepoInterface employeeRepoInterface;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeEntity> employeeEntityList =employeeRepoInterface.getAllEmployees();

        return employeeEntityList.stream().map(Employee->modelMapper
                .map(Employee,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(int id){
        EmployeeEntity employeeEntity = employeeRepoInterface.getEmployeeById(id);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employee){
        EmployeeEntity employeeEntity = modelMapper.map(employee,EmployeeEntity.class);
        employeeRepoInterface.saveEmployee(employeeEntity);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee, int id){
        EmployeeEntity employeeEntity =  modelMapper.map(employee,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity employeeEntity1 = employeeRepoInterface.updateEmployee(employeeEntity,id);
        return modelMapper.map(employeeEntity1,EmployeeDto.class);
    }

    @Override
    public EmployeeDto patchUpdateEmployee(EmployeeDto employee, int id){
        EmployeeEntity employeeEntity =  modelMapper.map(employee,EmployeeEntity.class);
        if(employee!=null)
        {
            if (employee.getFirstName()!=null)
            {
                employeeEntity.setFirstName(employee.getFirstName());
            }
            if (employee.getSalary()!=null)
            {
                employeeEntity.setSalary(employee.getSalary());
            }
            //TODO Save
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id){
        return employeeRepoInterface.deleteEmployee(id);
    }
}
