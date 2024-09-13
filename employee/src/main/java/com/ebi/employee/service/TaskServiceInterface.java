package com.ebi.employee.service;

import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;

public interface TaskServiceInterface {

    TaskDto addTask(TaskSaveDto task);

    TaskDto updateTask(TaskSaveDto task);

    TaskDto deleteTask(Long id);
}

