package com.ebi.employee.repo;

import com.ebi.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepoInterface extends JpaRepository<EmployeeEntity,Long> {

    //@Query (value = "from EmployeeEntity e where e.name = :name and e.email = :email")
    Optional<EmployeeEntity> findByNameAndEmail(String name ,String email);
}
