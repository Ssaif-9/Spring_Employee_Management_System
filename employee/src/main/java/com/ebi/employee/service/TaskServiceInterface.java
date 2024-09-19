package com.ebi.employee.service;

import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;

import java.util.List;

public interface TaskServiceInterface {

    List<TaskSaveDto> getAllTask ();

    List<TaskSaveDto> getEmployeeTasks(Long employeeId);

    TaskDto addTask(TaskSaveDto task);

    TaskDto updateTask(TaskSaveDto task);

    TaskDto deleteTask(Long id);
}

