package com.ebi.employee.controller;

import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskViewController {

    private final TaskServiceInterface taskServiceInterface;
    private final EmployeeRepoInterface employeeRepoInterface;

    @Value("${Success.Get.code}")
    private String GetCode;
    @Value("${Success.Get.Message}")
    private String GetMessage;


    @GetMapping("/list")
    public String getAllEmployeesWithView(Model model){
        List<TaskSaveDto> taskSaveDtoList = taskServiceInterface.getAllTask();
        GeneralResponse<List<TaskSaveDto>> response =new GeneralResponse<>(GetCode,GetMessage,taskSaveDtoList);
        model.addAttribute("response",response);
        return "listTask";
    }


    @GetMapping("/add")
    public String getAddTask(Model model){
            model.addAttribute("task", new TaskSaveDto());
            return "addTask";
    }

    @PostMapping("/add")
    public String AddTask(TaskSaveDto taskSaveDto ,Model model){
        Optional<EmployeeEntity> employeeSaveDto =employeeRepoInterface.findById(taskSaveDto.getEmployeeId());
       if(employeeSaveDto.isPresent()){
            taskServiceInterface.addTask(taskSaveDto);
            model.addAttribute("task",taskSaveDto);
            return "redirect:/employee/userHome";
        }
        else
            throw new CustomException("001","not Exist Employee","Can not find employee who make this task ");
    }

    @GetMapping("/delete")
    public String getDeleteTask(Model model){
        model.addAttribute("task", new TaskSaveDto());
        return "deleteTask";
    }

    @PostMapping("/delete")
    public String DeleteTask(@ModelAttribute("employeeEmail") String email,TaskSaveDto taskSaveDto , Model model){
            taskServiceInterface.deleteTask(email,taskSaveDto.getId());
            model.addAttribute("task",taskSaveDto.getId());
            return "redirect:/employee/userHome";
    }

    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException,Model model){
        model.addAttribute("error",customException);
        return "error";
    }
}
