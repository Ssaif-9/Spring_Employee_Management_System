package com.ebi.employee.controller;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.service.EmployeeServiceInf;
import com.ebi.employee.service.EmployeeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceInt employeeServiceInt;


    @GetMapping("/getEmployee")
    @ResponseBody
    public EmployeeDto getEmployee(){
        return employeeServiceInt.getEmployee();
    }

    @PostMapping("/postEmployee")
    @ResponseBody
    public String getEmployeePost(){
        return ("name " + employeeServiceInt.getEmployee().getEmployeeName());
    }
}
