package com.ebi.employee.controller;

import com.ebi.employee.exception.CustomException;
import com.ebi.employee.exception.ErrorException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.service.EmployeeServiceImplementation;
import com.ebi.employee.service.EmployeeServiceInterface;
import com.ebi.employee.util.mapper.EmployeeMapper;
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
public class EmployeeController {

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



    @ResponseBody
    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeServiceInterface.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response =new GeneralResponse<>(GetCode,GetMessage,employeeDtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }

    @GetMapping("/view")
    public String getAllEmployeesWithView(Model model){
        List<EmployeeDto> employeeDtoList = employeeServiceInterface.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response =new GeneralResponse<>(GetCode,GetMessage,employeeDtoList);
        model.addAttribute("response",response);
        return "employee";
    }

    @GetMapping("/register")
    public String getAddEmployee(Model model){
        model.addAttribute("employee", new EmployeeSaveDto());
        return "addEmployee";
    }

    @PostMapping("/register")
    public String registerEmployee( EmployeeSaveDto employeeSaveDto, Model model){
        EmployeeDto employeeDto=employeeServiceInterface.saveEmployee(employeeSaveDto);
        model.addAttribute("employee", new EmployeeDto());
        return "redirect:view";
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeServiceInterface.getEmployeeById(id);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(GetCode,GetMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @ResponseBody
    @GetMapping("/ByNameAndMail")
    public ResponseEntity<?> getEmployeeByNameAndMail(@RequestParam String name ,@RequestParam String email){
            EmployeeDto employeeDto=employeeServiceInterface.getEmployeeByNameAndMail(name, email);
            GeneralResponse<EmployeeDto> response =new GeneralResponse<>(GetCode,GetMessage,employeeDto);
            return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto=employeeServiceInterface.saveEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(AddCode,AddMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @ResponseBody
    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto= employeeServiceInterface.updateEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(UpdateCode,UpdateMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping
    public ResponseEntity<?> patchUpdateEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto= employeeServiceInterface.patchUpdateEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(UpdateCode,UpdateMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        EmployeeDto employeeDto= employeeServiceInterface.deleteEmployee(id);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(DeleteCode,DeleteMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException,Model model){
        model.addAttribute("error",customException);
        return "error";
    }


}
