package com.ebi.employee.controller;

import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.service.EmployeeServiceInterface;
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
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return employeeServiceInterface.getEmployeeById(id);
    }
    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employee){
        return employeeServiceInterface.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employee,@PathVariable int id){
        return employeeServiceInterface.updateEmployee(employee,id);
    }

    @PatchMapping("/{id}")
    public EmployeeDto patchUpdateEmployee(@RequestBody EmployeeDto employee, @PathVariable int id){
        return employeeServiceInterface.patchUpdateEmployee(employee,id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable int id){
        return employeeServiceInterface.deleteEmployee(id);
    }

}
