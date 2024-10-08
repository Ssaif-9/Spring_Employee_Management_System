package com.ebi.employee.repo;

import com.ebi.employee.entity.TaskEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepoInterface extends JpaRepository<TaskEntity,Long> {

    @Query(value = "select * from task  where employee_id =?",nativeQuery = true)
    List<TaskEntity> findMyQuery(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE from task where employee_id =?",nativeQuery = true)
    void  deleteAllTaskForOneEmployee(Long id);

}
