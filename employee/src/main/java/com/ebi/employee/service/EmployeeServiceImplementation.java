package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements  EmployeeServiceInterface{

    //@Qualifier("seif")
    @Autowired
    EmployeeRepoInterface employeeRepoInterface;

    @Override
    public  EmployeeDto getEmployee(){
        return employeeRepoInterface.getEmployee();
    }

}
