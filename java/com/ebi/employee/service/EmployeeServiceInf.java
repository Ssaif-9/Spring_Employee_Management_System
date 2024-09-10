package com.ebi.employee.service;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.repo.EmployeeRepoImp;
import com.ebi.employee.repo.EmployeeRepoInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceInf implements EmployeeServiceInt {

    //@Qualifier("bela")
    @Autowired
    EmployeeRepoInt employeeRepoInt;

    @Override
    public EmployeeDto getEmployee() {
        return employeeRepoInt.getEmployee();
    }


}
