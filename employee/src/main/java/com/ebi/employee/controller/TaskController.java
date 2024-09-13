package com.ebi.employee.controller;

import com.ebi.employee.entity.TaskEntity;
import com.ebi.employee.exception.ErrorException;
import com.ebi.employee.exception.TaskAddException;
import com.ebi.employee.exception.TaskDeleteException;
import com.ebi.employee.exception.TaskUpdateException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.GeneralResponse;
import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.repo.TaskRepoInterface;
import com.ebi.employee.service.TaskServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceInterface taskServiceInterface;

    @Value("${Success.Add.code}")
    private String AddCode;
    @Value("${Success.Add.Message}")
    private String AddMessage;

    @Value("${Success.Delete.code}")
    private String DeleteCode;
    @Value("${Success.Delete.Message}")
    private String DeleteMessage;

    @Value("${Success.Get.code}")
    private String GetCode;
    @Value("${Success.Get.Message}")
    private String GetMessage;

    @Value("${Success.Update.code}")
    private String UpdateCode;
    @Value("${Success.Update.Message}")
    private String UpdateMessage;

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody TaskSaveDto taskSaveDto) {
        TaskDto taskDto=taskServiceInterface.addTask(taskSaveDto);
        GeneralResponse<TaskDto> response =new GeneralResponse<>(AddCode,AddMessage,taskDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED); //201
    }

    @PatchMapping
    public ResponseEntity<?> patchUpdateEmployee(@RequestBody TaskSaveDto taskSaveDto) {
        TaskDto taskDto= taskServiceInterface.updateTask(taskSaveDto);
        GeneralResponse<TaskDto> response =new GeneralResponse<>(UpdateCode,UpdateMessage,taskDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        TaskDto taskDto = taskServiceInterface.deleteTask(id);
        GeneralResponse<TaskDto> response =new GeneralResponse<>(DeleteCode,DeleteMessage,taskDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(value = TaskAddException.class)
    ResponseEntity<?> addTaskExceptionHandler(TaskAddException taskAddException){
        ErrorException errorException =new ErrorException(taskAddException.getExceptionCode(),taskAddException.getExceptionMessage(),taskAddException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TaskDeleteException.class)
    ResponseEntity<?> deleteTaskExceptionHandler(TaskDeleteException taskDeleteException){
        ErrorException errorException =new ErrorException(taskDeleteException.getExceptionCode(),taskDeleteException.getExceptionMessage(),taskDeleteException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TaskUpdateException.class)
    ResponseEntity<?> updateTaskExceptionHandler(TaskUpdateException taskUpdateException){
        ErrorException errorException =new ErrorException(taskUpdateException.getExceptionCode(),taskUpdateException.getExceptionMessage(),taskUpdateException.getExceptionDetail());
        return new ResponseEntity<>(errorException, HttpStatus.NOT_FOUND);
    }

}
