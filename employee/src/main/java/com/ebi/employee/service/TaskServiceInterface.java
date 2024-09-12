package com.ebi.employee.service;

import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;

public interface TaskServiceInterface {

    TaskSaveDto addTask(TaskSaveDto task);

    TaskSaveDto updateTask(TaskSaveDto task);
}
