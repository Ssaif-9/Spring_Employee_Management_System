package com.ebi.employee.service;

import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface TaskServiceInterface {

    List<TaskSaveDto> getAllTask ();

    List<TaskSaveDto> getEmployeeTasks(Long employeeId);

    TaskDto addTask(TaskSaveDto task);

    TaskSaveDto updateTask(TaskSaveDto task);

    TaskDto deleteTask(String email,Long id);
}

