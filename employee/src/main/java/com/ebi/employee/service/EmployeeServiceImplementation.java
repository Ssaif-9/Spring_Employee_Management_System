package com.ebi.employee.service;

import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements  EmployeeServiceInterface {

    private final EmployeeRepoInterface employeeRepoInterface;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeSaveDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepoInterface.findAll();

        return employeeEntityList.stream().map(Employee -> modelMapper
                        .map(Employee, EmployeeSaveDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeSaveDto getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepoInterface.findById(id);
        if (employeeEntity.isPresent())
            return modelMapper.map(employeeEntity.get(), EmployeeSaveDto.class);
        else
            throw new CustomException("01", "Not Found", "No element of data has this ID : " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<EmployeeSaveDto> getEmployeeByName(String name) {
        List<EmployeeEntity> employeeEntityList = employeeRepoInterface.findByName(name);
        if (!employeeEntityList.isEmpty())
            //return modelMapper.map(employeeEntityList,EmployeeSaveDto.class);
            return employeeEntityList.stream()
                    .map(Employee -> modelMapper.map(Employee, EmployeeSaveDto.class))
                    .collect(Collectors.toList());
        else
            throw new CustomException("02", "Not Found", "No element of data has this Name : " + name, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<EmployeeSaveDto> getEmployeeByEmail(String email) {
        Optional<EmployeeEntity> employeeEntityList = employeeRepoInterface.findByEmail(email);
        if (employeeEntityList.isPresent())
            return employeeEntityList.stream()
                    .map(Employee -> modelMapper.map(Employee, EmployeeSaveDto.class))
                    .collect(Collectors.toList());
        else
            throw new CustomException("03", "Not Found", "No element of data has this Email : " + email, HttpStatus.NOT_FOUND);
    }

    public List<EmployeeSaveDto> getEmployeeBySalary(String salary){
        List<EmployeeEntity> employeeEntityList =employeeRepoInterface.findBySalary(salary);
        if(!employeeEntityList.isEmpty())
            return employeeEntityList.stream().map(Employee->modelMapper
                            .map(Employee, EmployeeSaveDto.class))
                    .collect(Collectors.toList());
        else
            throw new CustomException("05", "Not Found", "No element of data has this Salary : " + salary, HttpStatus.NOT_FOUND);
    }

    public List<EmployeeSaveDto> getEmployeeByGraterSalary(String salary){
        List<EmployeeEntity> employeeEntityList = employeeRepoInterface.findGreaterSalaryByCondation(salary);
        if(!employeeEntityList.isEmpty())
            return employeeEntityList.stream().map(Employee->modelMapper
                    .map(Employee,EmployeeSaveDto.class))
                    .collect(Collectors.toList());
        else
             throw new CustomException("05", "Not Found", "No Employee take : " + salary+" or More ", HttpStatus.NOT_FOUND);
    }

    public List<EmployeeSaveDto> getEmployeeByLessSalary(String salary){
        List<EmployeeEntity> employeeEntityList = employeeRepoInterface.findLessSalaryByCondation(salary);
        if(!employeeEntityList.isEmpty())
            return employeeEntityList.stream().map(Employee->modelMapper
                            .map(Employee,EmployeeSaveDto.class))
                            .collect(Collectors.toList());
        else
            throw new CustomException("05", "Not Found", "No Employee take : " + salary+" or Less ", HttpStatus.NOT_FOUND);

    }

    @Override
    public List<EmployeeSaveDto> getEmployeeByPhone(String phone) {
        List<EmployeeEntity> employeeEntityList = employeeRepoInterface.findByPhone(phone);
        if (!employeeEntityList.isEmpty())
            return employeeEntityList.stream().map(Employee -> modelMapper
                            .map(Employee, EmployeeSaveDto.class))
                    .collect(Collectors.toList());
        else
            throw new CustomException("04", "Not Found", "No element of data has this Phone : " + phone, HttpStatus.NOT_FOUND);
    }



    @Override
    public EmployeeDto saveEmployee(EmployeeSaveDto employee) {
        Optional<EmployeeEntity> employeeEntityList = employeeRepoInterface.findByEmail(employee.getEmail());
        if(employeeEntityList.isEmpty())
        {
            EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
            if (employeeEntity.getPhone().length() != 11 || !employeeEntity.getPhone().startsWith("01"))
                throw new CustomException("021", "Phone Number Error", "Phone number must be 11 digit and start with 01",HttpStatus.BAD_REQUEST);
            if (!employeeEntity.getEmail().contains(".com") || !employeeEntity.getEmail().contains("@"))
                throw new CustomException("022", "Email Address Error", "Email Address contains @ and .com",HttpStatus.BAD_REQUEST);
            employeeRepoInterface.save(employeeEntity);
            return modelMapper.map(employeeEntity, EmployeeDto.class);
        }
        else
            throw new CustomException("05", "Email", " This Email used before please enter another Email ", HttpStatus.BAD_REQUEST);

    }

    @Override
    public EmployeeDto updateEmployee(EmployeeSaveDto employee) {
        Optional<EmployeeEntity> employeeSaveDto = employeeRepoInterface.findById(employee.getId());
        if (employeeSaveDto.isEmpty())
            throw new CustomException("404", "Not Found", "No element of data has this ID to Update it .", HttpStatus.NOT_FOUND);
        else {
            EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
            if (employeeEntity.getPhone().length() != 11 || !employeeEntity.getPhone().startsWith("01"))
                throw new CustomException("047", "Phone Error", "Must Enter New Phone has 11 digit and start with 01",HttpStatus.BAD_REQUEST);
            if (!employeeEntity.getEmail().contains(".com") || !employeeEntity.getEmail().contains("@"))
                throw new CustomException("046", "Email Error", "Must Enter New Email must include @ and .com",HttpStatus.BAD_REQUEST);
            EmployeeEntity employeeEntity1 = employeeRepoInterface.save(employeeEntity);
            return modelMapper.map(employeeEntity1, EmployeeDto.class);
        }
    }

    @Override
    public EmployeeDto patchUpdateEmployee(EmployeeSaveDto employee) {
        EmployeeEntity savedEmployeeEntity = null;

        if (employee.getId() != null) {
            Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(employee.getId());
            if (employeeEntityOptional.isPresent()) {
                if (!employee.getName().isEmpty()) {
                    if (!employee.getName().equals(employeeEntityOptional.get().getName()))
                        employeeEntityOptional.get().setName(employee.getName());
                    else
                        throw new CustomException("043", "Name Error", "Must Enter New Name ", HttpStatus.BAD_REQUEST);
                }
                if (!employee.getSalary().isEmpty()) {
                    employeeEntityOptional.get().setSalary(employee.getSalary());
                }
                if (!employee.getAddress().isEmpty()) {
                    employeeEntityOptional.get().setAddress(employee.getAddress());
                }
                if (!employee.getEmail().isEmpty()) {
                    if (employee.getEmail().contains(".com") && employee.getEmail().contains("@"))
                        employeeEntityOptional.get().setEmail(employee.getEmail());
                    else
                        throw new CustomException("046", "Email Error", "Must Enter New Email must include @ and .com",HttpStatus.BAD_REQUEST);
                }
                if (!employee.getPhone().isEmpty()) {
                    if (employee.getPhone().length() == 11 && employee.getPhone().startsWith("01"))
                        employeeEntityOptional.get().setPhone(employee.getPhone());
                    else
                        throw new CustomException("047", "Phone Error", "Must Enter New Phone has 11 digit and start with 01",HttpStatus.BAD_REQUEST);
                }
            } else
                throw new CustomException("042", "Miss Employee", "No Employee with id : " + employee.getId(), HttpStatus.NOT_FOUND);
            savedEmployeeEntity = employeeRepoInterface.save(employeeEntityOptional.get());
        } else
            throw new CustomException("041", "Miss ID", "Must Send Employee ID", HttpStatus.BAD_REQUEST);
        return modelMapper.map(savedEmployeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeDto deleteEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(id);
        if (employeeEntityOptional.isPresent()) {
            employeeRepoInterface.deleteById(id);
            return modelMapper.map(employeeEntityOptional.get(), EmployeeDto.class);
        } else
            throw new CustomException("061", "Miss Employee", "No Employee with id : " + id + " to Delete it .", HttpStatus.NOT_FOUND);
    }

    @Override
    public String loginEmployee(String email, String phone) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findByEmailAndPhone(email, phone);
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            if (employeeEntity.getEmail().equals("admin@admin.com") && employeeEntity.getPhone().equals("01000000000"))
                return "admin";
            else
                return "user";
        } else
            throw new CustomException("999", "can not login", "User or password not found ", HttpStatus.NOT_FOUND);
    }
}
