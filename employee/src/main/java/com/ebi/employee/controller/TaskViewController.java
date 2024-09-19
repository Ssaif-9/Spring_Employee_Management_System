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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



    @PostMapping("/add")
    public String getAddTask(TaskSaveDto taskSaveDto ,Model model){
        Optional<EmployeeEntity> employeeSaveDto =employeeRepoInterface.findById(taskSaveDto.getEmployeeId());
       if(employeeSaveDto.isPresent()){
            taskServiceInterface.addTask(taskSaveDto);
            model.addAttribute("task",taskSaveDto);
            return "addTask";
        }
        else
            throw new CustomException("001","not Exist Employee","Can not find employee who make this task ");

    }




}
