package com.ebi.employee.repo;

import com.ebi.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepoInterface extends JpaRepository<EmployeeEntity,Long> {

}
