package com.ebi.employee.controller;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

    @GetMapping("/getEmployee")
    @ResponseBody
    public EmployeeDto getEmployee(){
        return employeeServiceInterface.getEmployee();
    }

    @PostMapping("/postEmployee")
    @ResponseBody
    public String postEmployee(){
        return ("User Name  : "+ employeeServiceInterface.getEmployee().getFirstName());
    }
}
