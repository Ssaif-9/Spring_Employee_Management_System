package com.ebi.employee.repo;

import com.ebi.employee.model.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImplementation implements EmployeeRepoInterface {

    @Override
    public List<EmployeeEntity> getAllEmployees(){
        List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();

        EmployeeEntity employeeEntity1= new EmployeeEntity(1,"Seif Eldin","Sultan","15000");
        EmployeeEntity employeeEntity2=new EmployeeEntity(3,"mazen","Naser","16000");
        employees.add(employeeEntity1);
        employees.add(employeeEntity2);
        return employees;
    }

    @Override
    public EmployeeEntity getEmployeeById(int id){
        return new EmployeeEntity(1,"Seif Eldin","Sultan","15000");
    }

    @Override
    public  EmployeeEntity saveEmployee(EmployeeEntity employeeEntity){
        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, int id){
        return employeeEntity;
    }

    @Override
    public  EmployeeEntity patchUpdateEmployee(EmployeeEntity employeeEntity, int id){
        return employeeEntity;
    }

    @Override
    public boolean deleteEmployee(int id){
        return true;
    }
}
