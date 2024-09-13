package com.ebi.employee.repo;

import com.ebi.employee.entity.EmployeeEntity;
import com.ebi.employee.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepoInterface extends JpaRepository<TaskEntity,Long> {

}
