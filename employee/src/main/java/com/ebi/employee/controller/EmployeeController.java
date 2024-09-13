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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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




    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeServiceInterface.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response =new GeneralResponse<>(GetCode,GetMessage,employeeDtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeServiceInterface.getEmployeeById(id);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(GetCode,GetMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/ByNameAndMail")
    public ResponseEntity<?> getEmployeeByNameAndMail(@RequestParam String name ,@RequestParam String mail){
            EmployeeDto employeeDto=employeeServiceInterface.getEmployeeByNameAndMail(name, mail);
            GeneralResponse<EmployeeDto> response =new GeneralResponse<>(GetCode,GetMessage,employeeDto);
            return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto=employeeServiceInterface.saveEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(AddCode,AddMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto= employeeServiceInterface.updateEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(UpdateCode,UpdateMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> patchUpdateEmployee(@RequestBody EmployeeSaveDto employee){
        EmployeeDto employeeDto= employeeServiceInterface.patchUpdateEmployee(employee);
        GeneralResponse<EmployeeDto> response =new GeneralResponse<>(UpdateCode,UpdateMessage,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeServiceInterface.deleteEmployee(id);
        GeneralResponse<String> response =new GeneralResponse<>(DeleteCode,DeleteMessage,"true");
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @ExceptionHandler
    ResponseEntity<?> notFoundHandler(CustomException customException){
        ErrorException errorException =new ErrorException(customException.getExceptionDetail(),customException.getExceptionMessage(),customException.getExceptionMessage());
        return new ResponseEntity<>(errorException,HttpStatus.OK);
    }

}
