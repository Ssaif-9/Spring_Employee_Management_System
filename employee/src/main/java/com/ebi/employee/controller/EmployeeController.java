package com.ebi.employee.controller;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.service.EmployeeServiceImplementation;
import com.ebi.employee.service.EmployeeServiceInterface;
import com.ebi.employee.util.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceInterface employeeServiceInterface;


    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return employeeServiceInterface.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable long id){
        return employeeServiceInterface.getEmployeeById(id);
    }
    @PostMapping
    public EmployeeSaveDto saveEmployee(@RequestBody EmployeeSaveDto employee){
        return employeeServiceInterface.saveEmployee(employee);
    }

    @PutMapping
    public EmployeeSaveDto updateEmployee(@RequestBody EmployeeSaveDto employee){
        return employeeServiceInterface.updateEmployee(employee);
    }

    @PatchMapping
    public EmployeeSaveDto patchUpdateEmployee(@RequestBody EmployeeSaveDto employee){
        return employeeServiceInterface.patchUpdateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
         employeeServiceInterface.deleteEmployee(id);
    }

}
