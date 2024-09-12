package com.ebi.employee.repo;

import com.ebi.employee.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepoInterface extends JpaRepository<TaskEntity,Long> {

}
