package com.ebi.employee.repo;

import com.ebi.employee.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Qualifier("bela")
//@Primary
@Repository
public class EmpolyeeRepoImp1 implements EmployeeRepoInt {


    @Override
    public EmployeeDto getEmployee() {
        return new EmployeeDto(1L,"salsabil Sultan","15000");
    }
}
