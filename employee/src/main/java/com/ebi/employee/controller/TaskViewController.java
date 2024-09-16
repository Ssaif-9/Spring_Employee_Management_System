package com.ebi.employee.controller;

import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskViewController {

    private final TaskServiceInterface taskServiceInterface;

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


}
