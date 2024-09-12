package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements  EmployeeServiceInterface{

    private final EmployeeRepoInterface employeeRepoInterface;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeEntity> employeeEntityList =employeeRepoInterface.findAll();

        return employeeEntityList.stream().map(Employee->modelMapper
                .map(Employee,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(long id){
        /*
        Optional<EmployeeEntity> employeeEntity = employeeRepoInterface.findById(id);
        return employeeEntity.map(entity -> modelMapper.map(entity, EmployeeDto.class)).orElse(null);
        * */
        EmployeeEntity employeeEntity = employeeRepoInterface.findById(id).orElse(null);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeSaveDto saveEmployee(EmployeeSaveDto employee){
        EmployeeEntity employeeEntity = modelMapper.map(employee,EmployeeEntity.class);
        employeeRepoInterface.save(employeeEntity);
        return modelMapper.map(employeeEntity,EmployeeSaveDto.class);
    }

    @Override
    public EmployeeSaveDto updateEmployee(EmployeeSaveDto employee){
        EmployeeEntity employeeEntity =  modelMapper.map(employee,EmployeeEntity.class);
        EmployeeEntity employeeEntity1 = employeeRepoInterface.save(employeeEntity);
        return modelMapper.map(employeeEntity1,EmployeeSaveDto.class);
    }

    @Override
    public EmployeeSaveDto patchUpdateEmployee(EmployeeSaveDto employee){
        EmployeeEntity savedEmployeeEntity =null;
        if(employee!=null)
        {
            Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(employee.getId());
        if(employeeEntityOptional.isPresent()){
            if (employee.getName()!=null)
            {
                employeeEntityOptional.get().setName(employee.getName());
            }
            if (employee.getSalary()!=null)
            {
                employeeEntityOptional.get().setSalary(employee.getSalary());
            }
            if (employee.getAddress()!=null)
            {
                employeeEntityOptional.get().setAddress(employee.getAddress());
            }
            if (employee.getEmail()!=null)
            {
                employeeEntityOptional.get().setEmail(employee.getEmail());
            }
            if (employee.getPhone()!=null)
            {
                employeeEntityOptional.get().setPhone(employee.getPhone());
            }
        }
            savedEmployeeEntity = employeeRepoInterface.save(employeeEntityOptional.get());
        }
        return modelMapper.map(savedEmployeeEntity,EmployeeSaveDto.class);
    }

    @Override
    public void deleteEmployee(long id){
         employeeRepoInterface.deleteById(id);
    }
}
