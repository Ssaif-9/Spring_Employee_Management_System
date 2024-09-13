package com.ebi.employee.controller;

import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceInterface taskServiceInterface;

    @PostMapping
    public TaskDto saveEmployee(@RequestBody TaskSaveDto taskSaveDto) {
        return taskServiceInterface.addTask(taskSaveDto);
    }

    @PatchMapping
    public TaskDto patchUpdateEmployee(@RequestBody TaskSaveDto taskSaveDto) {
        return taskServiceInterface.updateTask(taskSaveDto);
    }

    @DeleteMapping("/{id}")
    public TaskDto deleteEmployee(@PathVariable Long id) {
        return taskServiceInterface.deleteTask(id);
    }
}
