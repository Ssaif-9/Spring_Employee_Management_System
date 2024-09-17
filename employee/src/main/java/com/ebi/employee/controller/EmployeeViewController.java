package com.ebi.employee.controller;

import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.service.EmployeeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeViewController {

    private final EmployeeServiceInterface employeeServiceInterface;

    @Value("${Success.Add.code}")
    private String AddCode;
    @Value("${Success.Add.Message}")
    private String AddMessage;

    @Value("${Success.Delete.code}")
    private String DeleteCode;
    @Value("${Success.Delete.Message}")
    private String DeleteMessage;

    @Value("${Success.Get.code}")
    private String GetCode;
    @Value("${Success.Get.Message}")
    private String GetMessage;

    @Value("${Success.Update.code}")
    private String UpdateCode;
    @Value("${Success.Update.Message}")
    private String UpdateMessage;

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("employee", new EmployeeSaveDto());
        return "Login";
    }

    @PostMapping("/login")
    public String loginEmployee (EmployeeSaveDto employeeSaveDto ,Model model)
    {
       EmployeeDto employeeDto= employeeServiceInterface.loginEmployee(employeeSaveDto.getEmail(),employeeSaveDto.getPhone());
        model.addAttribute("employee", employeeDto);
        return "redirect:home";
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

    @GetMapping("/list")
    public String getAllEmployeesWithView(Model model){
        List<EmployeeSaveDto> employeeSaveDtoList = employeeServiceInterface.getAllEmployees();
        GeneralResponse<List<EmployeeSaveDto>> response =new GeneralResponse<>(GetCode,GetMessage,employeeSaveDtoList);
        model.addAttribute("response",response);
        return "listEmployee";
    }

    @GetMapping("/add")
    public String getAddEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        EmployeeDto employeeDto=employeeServiceInterface.saveEmployee(employeeSaveDto);
        model.addAttribute("employee", new EmployeeDto());
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String getDeleteEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "deleteEmployee";
    }

    @PostMapping("/delete")
    public String deleteEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        EmployeeDto employeeDto=employeeServiceInterface.deleteEmployee(employeeSaveDto.getId());
        model.addAttribute("employee", employeeSaveDto.getId());
        return "redirect:list";
    }

    @GetMapping("/search")
    public String getSearchEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "searchEmployee";
    }

    @PostMapping("/search")
    public String searchEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        EmployeeSaveDto employeeDto =employeeServiceInterface.getEmployeeById(employeeSaveDto.getId());
        model.addAttribute("employee", employeeDto);
        return "subListEmployee";
    }

    @GetMapping("/searchByName")
    public String getSearchByNameEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "searchByNameEmployee";
    }

    @PostMapping("/searchByName")
    public String searchByNameEmployee( EmployeeSaveDto employeeSaveDtoArgu, Model model){
        List<EmployeeSaveDto> employeeSaveDtoList = employeeServiceInterface.getEmployeeByName(employeeSaveDtoArgu.getName());
        model.addAttribute("employee", employeeSaveDtoList);
        return "subListEmployee";
    }

    @GetMapping("/searchByEmail")
    public String getSearchByEmailEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "searchByEmailEmployee";
    }

    @PostMapping("/searchByEmail")
    public String searchByEmailEmployee( EmployeeSaveDto employeeSaveDtoArgu, Model model){
        List<EmployeeSaveDto> employeeSaveDto =employeeServiceInterface.getEmployeeByEmail(employeeSaveDtoArgu.getEmail());
        model.addAttribute("employee", employeeSaveDto);
        return "subListEmployee";
    }

    @GetMapping("/searchByPhone")
    public String getSearchByPhoneEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "searchByPhoneEmployee";
    }

    @PostMapping("/searchByPhone")
    public String searchByPhoneEmployee( EmployeeSaveDto employeeSaveDtoArgu, Model model){
        List<EmployeeSaveDto> employeeSaveDto =employeeServiceInterface.getEmployeeByPhone(employeeSaveDtoArgu.getPhone());
        model.addAttribute("employee", employeeSaveDto);
        return "subListEmployee";
    }

    @GetMapping("/update")
    public String getUpdateEmployee (Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "updateEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        employeeServiceInterface.updateEmployee(employeeSaveDto);
        model.addAttribute("employee", new EmployeeDto());
        return "redirect:list";
    }

    @GetMapping("/patch")
    public String getPatchEmployee (Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "patchEmployee";
    }

    @PostMapping("/patch")
    public String patchEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        EmployeeDto employeeDto=employeeServiceInterface.patchUpdateEmployee(employeeSaveDto);
        model.addAttribute("employee", new EmployeeSaveDto());
        return "redirect:list";
    }





    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException,Model model){
        model.addAttribute("error",customException);
        return "error";
    }


}
