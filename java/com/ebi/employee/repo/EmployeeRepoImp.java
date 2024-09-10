package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Qualifier("Seif")
@Primary
@Repository
public class EmployeeRepoImp implements EmployeeRepoInt {



    @Override
    public EmployeeDto getEmployee() {
        return new EmployeeDto(5L,"SAIF Sultan","15000");
    }
}

