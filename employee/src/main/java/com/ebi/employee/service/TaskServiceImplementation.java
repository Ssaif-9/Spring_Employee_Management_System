package com.ebi.employee.service;

import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.entity.TaskEntity;
import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import com.ebi.employee.repo.TaskRepoInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskServiceInterface {

    private final TaskRepoInterface taskRepoInterface;
    private final ModelMapper modelMapper;
    private final EmployeeRepoInterface employeeRepoInterface;


    public TaskDto addTask(TaskSaveDto task) {

        TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
        taskEntity.setEmployeeEntity(employeeRepoInterface.getById(task.getEmployeeId()));
        taskRepoInterface.save(taskEntity);
        return modelMapper.map(taskEntity, TaskDto.class);
    }

    @Override
    public TaskDto updateTask(TaskSaveDto task) {
        TaskEntity saveTaskEntity = null;
        if (task != null) {
            Optional<TaskEntity> taskEntityOptional = taskRepoInterface.findById(task.getId());
            if (taskEntityOptional.isPresent()) {
                if (task.getName() != null) {
                    taskEntityOptional.get().setName(task.getName());
                }
                if (task.getDescription() != null) {
                    taskEntityOptional.get().setDescription(task.getDescription());
                }
                if (task.getDate() != null) {
                    taskEntityOptional.get().setDate(task.getDate());
                }
                if (task.getEmployeeId() != null) {
                    Optional<EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(task.getEmployeeId());
                    if (employeeEntityOptional.isPresent()) {
                        taskEntityOptional.get().setEmployeeEntity(employeeEntityOptional.get());
                    }
                }
            }
            saveTaskEntity = taskRepoInterface.save(taskEntityOptional.get());
        }
        return modelMapper.map(saveTaskEntity, TaskDto.class);
    }
   @Override
   public TaskDto deleteTask(Long id)
   {
       TaskEntity taskEntity = taskRepoInterface.findById(id).get();
       taskRepoInterface.deleteById(id);
       return modelMapper.map(taskEntity, TaskDto.class);
   }

}
