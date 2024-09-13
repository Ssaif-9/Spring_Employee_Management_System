package com.ebi.employee.service;

import com.ebi.employee.exception.EmployeeGetException;
import com.ebi.employee.exception.EmployeeSaveException;
import com.ebi.employee.exception.EmployeeUpdateException;
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
    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepoInterface.findById(id);
        if(employeeEntity.isPresent())
            return modelMapper.map(employeeEntity.get(),EmployeeDto.class);
        else
            throw new EmployeeGetException("01","Not Found","No element of data has this ID : " + id) ;
    }

    @Override
    public EmployeeDto getEmployeeByNameAndMail(String name, String email) {
        Optional<EmployeeEntity> employeeEntity = employeeRepoInterface.findByMyQuery(name,email);
        if(employeeEntity.isPresent())
            return modelMapper.map(employeeEntity.get(),EmployeeDto.class);
        else
            throw new EmployeeGetException("051","Miss Employee ","No Employee with name : "+name+" and email : "+email);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeSaveDto employee){
        EmployeeEntity employeeEntity = modelMapper.map(employee,EmployeeEntity.class);
        if(employeeEntity.getPhone().length()!=11||!employeeEntity.getPhone().startsWith("01"))
            throw new EmployeeSaveException("021","Phone Number Error","Phone number must be 11 digit and start with 01");
        if(!employeeEntity.getEmail().contains(".com")||!employeeEntity.getEmail().contains("@"))
            throw new EmployeeSaveException("022","Email Address Error","Email Address contains @ and .com");
        employeeRepoInterface.save(employeeEntity);
        return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeSaveDto employee){
        EmployeeEntity employeeEntity =  modelMapper.map(employee,EmployeeEntity.class);
        if(employeeEntity.getEmail()==null||employeeEntity.getSalary()==null||employeeEntity.getAddress()==null||employeeEntity.getPhone()==null||employeeEntity.getName()==null)
            throw new EmployeeUpdateException("033","Empty Field","Must Enter Name , Phone , Email , Salary , Address .");
        if(employeeEntity.getPhone().length()!=11||!employeeEntity.getPhone().startsWith("01"))
            throw new EmployeeUpdateException("031","Phone Number Error","Phone number must be 11 digit and start with 01");
        if(!employeeEntity.getEmail().contains(".com")||!employeeEntity.getEmail().contains("@"))
            throw new EmployeeUpdateException("032","Email Address Error","Email Address contains @ and .com");
        EmployeeEntity employeeEntity1 = employeeRepoInterface.save(employeeEntity);
        return modelMapper.map(employeeEntity1,EmployeeDto.class);
    }

    @Override
    public EmployeeDto patchUpdateEmployee(EmployeeSaveDto employee){
        EmployeeEntity savedEmployeeEntity =null;

        if(employee.getId()!=null)
        {
            Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(employee.getId());
        if(employeeEntityOptional.isPresent()){
            if (employee.getName()!=null) {
               if(!employee.getName().equals(employeeEntityOptional.get().getName()))
                   employeeEntityOptional.get().setName(employee.getName());
               else
                   throw new EmployeeUpdateException("043","Name Error","Must Enter New Name ");
            }
            if (employee.getSalary()!=null) {
                if(!employee.getSalary().equals(employeeEntityOptional.get().getSalary()))
                    employeeEntityOptional.get().setSalary(employee.getSalary());
                else
                    throw new EmployeeUpdateException("044","Salary Error","Must Enter New Salary ");
            }
            if (employee.getAddress()!=null)
            {
                if(!employee.getAddress().equals(employeeEntityOptional.get().getAddress()))
                    employeeEntityOptional.get().setAddress(employee.getAddress());
                else
                    throw new EmployeeUpdateException("045","Address Error","Must Enter New Address ");
            }
            if (employee.getEmail()!=null)
            {
                if(!employee.getEmail().equals(employeeEntityOptional.get().getEmail()) && employee.getEmail().contains(".com") && employee.getEmail().contains("@"))
                    employeeEntityOptional.get().setEmail(employee.getEmail());
                else
                    throw new EmployeeUpdateException("046","Email Error","Must Enter New Email must include @ and .com");
            }
            if (employee.getPhone()!=null)
            {
                if(employee.getPhone().length()==11 && employee.getPhone().startsWith("01") && !employee.getPhone().equals(employeeEntityOptional.get().getPhone()))
                    employeeEntityOptional.get().setPhone(employee.getPhone());
                else
                    throw new EmployeeUpdateException("047","Phone Error","Must Enter New Phone has 11 digit and start with 01");
            }
        }else
            throw new EmployeeGetException("042","Miss Employee","No Employee with id : "+employee.getId());
        savedEmployeeEntity = employeeRepoInterface.save(employeeEntityOptional.get());
        } else
            throw new EmployeeUpdateException("041","Miss ID","Must Send Employee ID");
        return modelMapper.map(savedEmployeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeDto deleteEmployee(Long id){
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(id);
        if(employeeEntityOptional.isPresent())
        {
            employeeRepoInterface.deleteById(id);
            return modelMapper.map(employeeEntityOptional.get(),EmployeeDto.class);
        }
        else
            throw new EmployeeUpdateException("061","Miss Employee","No Employee with id : "+id+" to Delete it .");
    }



}
