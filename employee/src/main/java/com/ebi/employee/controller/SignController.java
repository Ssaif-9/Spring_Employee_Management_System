package com.ebi.employee.controller;

import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.service.EmployeeServiceInterface;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("employeeEmail")
@RequiredArgsConstructor
public class SignController {

    private final EmployeeServiceInterface employeeServiceInterface;
    private final TaskServiceInterface taskServiceInterface;


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("employee", new EmployeeSaveDto());
        return "Login";
    }

    @PostMapping("/login")
    public String loginEmployee (EmployeeSaveDto employeeSaveDtoArg ,Model model) {
        String employeeRole= employeeServiceInterface.loginEmployee(employeeSaveDtoArg.getEmail(),employeeSaveDtoArg.getPhone());
        if (employeeRole.equals("admin")) {
            return "redirect:employee/adminHome";
        }
        else {
            model.addAttribute("employeeEmail",employeeSaveDtoArg.getEmail());
            return "redirect:employee/userHome";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("employee", new EmployeeSaveDto());
        return "Register";
    }

    @PostMapping("/register")
    public String registerEmployee (EmployeeSaveDto employeeSaveDto ,Model model)
    {
        EmployeeDto employeeDto=employeeServiceInterface.saveEmployee(employeeSaveDto);
        model.addAttribute("employee", new EmployeeDto());
        return "redirect:login";
    }

    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException,Model model){
        model.addAttribute("error",customException);
        return "error";
    }
}
