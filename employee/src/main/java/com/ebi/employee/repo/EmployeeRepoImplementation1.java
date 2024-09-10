package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Primary
//@Qualifier("abdo")
@Repository
public class EmployeeRepoImplementation1 implements EmployeeRepoInterface{

    @Override
    public EmployeeDto getEmployee (){
       return new EmployeeDto(2L,"Abdel Rahman Hassan","18000");
    }
}
