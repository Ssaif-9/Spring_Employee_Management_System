package com.ebi.employee.controller;

import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
@SessionAttributes("employeeEmail")
@RequiredArgsConstructor
public class TaskViewController {

    private final TaskServiceInterface taskServiceInterface;
    private final EmployeeRepoInterface employeeRepoInterface;
    private final ModelMapper modelMapper;

    @Value("${Success.Get.code}")
    private String GetCode;
    @Value("${Success.Get.Message}")
    private String GetMessage;


    @GetMapping("/list")
    public String getAllTask(Model model){
        List<TaskSaveDto> taskSaveDtoList = taskServiceInterface.getAllTask();
        GeneralResponse<List<TaskSaveDto>> response =new GeneralResponse<>(GetCode,GetMessage,taskSaveDtoList);
        model.addAttribute("response",response);
        return "listTask";
    }

    @GetMapping("/add")
    public String getAddTask(@ModelAttribute("employeeEmail") String email, Model model){
       List<EmployeeEntity> employeeEntity= employeeRepoInterface.findByEmail(email);
       if(!employeeEntity.isEmpty()){
           EmployeeEntity employeeEntityFirst = employeeEntity.get(0);
           model.addAttribute("task", new TaskSaveDto(employeeEntityFirst.getId()));
           return "addTask";
       }
       else
           throw new CustomException("000","not found","No Employee Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public String AddTask(TaskSaveDto taskSaveDto ){
        Optional<EmployeeEntity> employeeSaveDto =employeeRepoInterface.findById(taskSaveDto.getEmployeeId());
       if(employeeSaveDto.isPresent()){
            taskServiceInterface.addTask(taskSaveDto);
            return "redirect:/employee/userHome";
        }
        else
            throw new CustomException("001","not Exist Employee","Can not find employee who make this task ",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/delete")
    public String getDeleteTask(Model model){
        model.addAttribute("task", new TaskSaveDto());
        return "deleteTask";
    }

    @PostMapping("/delete")
    public String DeleteTask(@ModelAttribute("employeeEmail") String email,TaskSaveDto taskSaveDto){
            taskServiceInterface.deleteTask(email,taskSaveDto.getId());
            return "redirect:/employee/userHome";
    }

    @GetMapping("/update")
    public String getUpdateTask(@ModelAttribute("employeeEmail") String email,Model model){
        List<EmployeeEntity> employeeEntity= employeeRepoInterface.findByEmail(email);
        if(!employeeEntity.isEmpty()){
            EmployeeEntity employeeEntityFirst = employeeEntity.get(0);
            model.addAttribute("task", new TaskSaveDto(employeeEntityFirst.getId()));
            return "updateTask";
        }
        else
            throw new CustomException("000","not found","No Employee Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/update")
    public String UpdateTask(TaskSaveDto taskSaveDtoArgu){
        taskServiceInterface.updateTask(taskSaveDtoArgu);
        return "redirect:/employee/userHome";
    }

    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException,Model model){
        model.addAttribute("error",customException);
        return "error";
    }
}
