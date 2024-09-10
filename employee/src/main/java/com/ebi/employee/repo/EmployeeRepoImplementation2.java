package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
//@Qualifier("seif")
@Repository
public class EmployeeRepoImplementation2 implements EmployeeRepoInterface {

    @Override
   public  EmployeeDto getEmployee (){
        return new EmployeeDto(1,"Seif Eldin ","Sultan","17000");
    }
}
