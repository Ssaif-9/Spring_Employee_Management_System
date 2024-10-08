package com.ebi.employee.service;

import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.entity.TaskEntity;
import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.model.TaskDto;
import com.ebi.employee.model.TaskSaveDto;
import com.ebi.employee.repo.EmployeeRepoInterface;
import com.ebi.employee.repo.TaskRepoInterface;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@SessionAttributes("employeeEmail")
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskServiceInterface {

    private final TaskRepoInterface taskRepoInterface;
    private final ModelMapper modelMapper;
    private final EmployeeRepoInterface employeeRepoInterface;

    public List<TaskSaveDto> getAllTask (){
        List<TaskEntity> taskEntityList =taskRepoInterface.findAll();
        return taskEntityList.stream().map(Task->modelMapper
                        .map(Task,TaskSaveDto.class))
                        .collect(Collectors.toList());
    }

    public List<TaskSaveDto> getEmployeeTasks(Long employeeId){
        List<TaskEntity> taskEntityList =taskRepoInterface.findMyQuery(employeeId);
            return taskEntityList.stream().map(Task->modelMapper
                            .map(Task,TaskSaveDto.class))
                            .collect(Collectors.toList());
    }

    public TaskDto addTask(TaskSaveDto task) {
        TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
        if (!taskEntity.getDate().matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$"))
            throw new CustomException("011", "Date Form", "Please Enter Date Form dd/MM/yyyy", HttpStatus.BAD_REQUEST);
        Optional <EmployeeEntity> employeeEntityOptional = employeeRepoInterface.findById(task.getEmployeeId());
        if (employeeEntityOptional.isPresent()) {
            taskEntity.setEmployeeEntity(employeeRepoInterface.getById(task.getEmployeeId()));
            taskRepoInterface.save(taskEntity);
            return modelMapper.map(taskEntity, TaskDto.class);
        }
        else
            throw new CustomException("012", "Employee Not Found", "Please Enter Employee who do this task",HttpStatus.NOT_FOUND);
    }

    @Override
    public TaskSaveDto updateTask(TaskSaveDto task) {
        Optional<TaskEntity> taskEntityOptional = taskRepoInterface.findById(task.getId());     //task from database
        List<TaskSaveDto> taskEntityOptionalList =taskEntityOptional.stream().map(Task->modelMapper.map(Task,TaskSaveDto.class)).toList();

         List<TaskEntity> taskEntityList = taskRepoInterface.findMyQuery(task.getEmployeeId());
         List<TaskSaveDto> taskSaveDtoList =taskEntityList.stream().map(Task->modelMapper.map(Task,TaskSaveDto.class)).toList(); //all employee task

        if (taskEntityOptional.isPresent()) {
            if (taskSaveDtoList.stream().anyMatch(Task -> Task.getEmployeeId().equals(taskEntityOptionalList.get(0).getEmployeeId()))){
                TaskEntity saveTaskEntity = null;
                    if (task.getId() != null) {
                        if (!task.getName().isEmpty())
                            taskEntityOptional.get().setName(task.getName());
                        if (!task.getDescription().isEmpty())
                            taskEntityOptional.get().setDescription(task.getDescription());
                        if (!task.getDate().isEmpty()) {
                            if(task.getDate().matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$"))
                                taskEntityOptional.get().setDate(task.getDate());
                            else
                                throw new CustomException("025","Date Error","Must Enter New date with  Form dd/MM/yyyy",HttpStatus.BAD_REQUEST);
                        }
                        saveTaskEntity = taskRepoInterface.save(taskEntityOptional.get());
                    }else
                        throw new CustomException ("021","Not Found Task","miss this Task data",HttpStatus.NOT_FOUND);
                    return modelMapper.map(saveTaskEntity, TaskSaveDto.class);
                } else {
                    throw new CustomException("044", "Not Allowed", "Must update only your tasks",HttpStatus.BAD_REQUEST);
                }
        } else {
            throw new CustomException("031", "Not Found Task", "No Task with id : " + task.getId() + " to delete it",HttpStatus.NOT_FOUND);
        }
    }

   @Override
   public TaskDto deleteTask(@ModelAttribute("employeeEmail") String email, Long id) {
       Optional<TaskEntity> taskEntityOptional = taskRepoInterface.findById(id);
       if (taskEntityOptional.isPresent()) {
           TaskSaveDto taskSaveDto = modelMapper.map(taskEntityOptional.get(), TaskSaveDto.class);
           Optional<EmployeeEntity> employeeSaveDto = employeeRepoInterface.findById(taskSaveDto.getEmployeeId());

           if (employeeSaveDto.isPresent()) {
               EmployeeSaveDto employeeSaveDto1 = modelMapper.map(employeeSaveDto.get(), EmployeeSaveDto.class);

               if (employeeSaveDto1.getEmail().trim().equalsIgnoreCase(email.trim())) {
                   taskRepoInterface.deleteById(id);
                   return modelMapper.map(taskEntityOptional.get(), TaskDto.class);
               } else {
                   throw new CustomException("044", "Not Allowed", "Must delete only your tasks",HttpStatus.BAD_REQUEST);
               }
           } else {
               throw new CustomException("031", "Not Found Employee",    "No Employee found for this task",HttpStatus.NOT_FOUND);
           }
       } else {
           throw new CustomException("031", "Not Found Task", "No Task with id : " + id + " to delete it",HttpStatus.NOT_FOUND);
       }
   }


    @Override
    public void deleteAllTasksFormOneEmployee(String email){
        System.out.println(email);
           Optional<EmployeeEntity> employeeSaveDto = employeeRepoInterface.findByEmail(email);

           if(employeeSaveDto.isEmpty())
               throw new CustomException("003","Not Found Employee","No Employee found for this task",HttpStatus.NOT_FOUND);

           EmployeeSaveDto employeeSaveDto1 = modelMapper.map(employeeSaveDto.get(), EmployeeSaveDto.class);
           taskRepoInterface.deleteAllTaskForOneEmployee(employeeSaveDto1.getId());
    }
}
