package com.ebi.employee.repo;

import com.ebi.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepoInterface extends JpaRepository<EmployeeEntity,Long> {

    List<EmployeeEntity> findByName(String name);

    List<EmployeeEntity> findByEmail(String email);

    List<EmployeeEntity> findByPhone(String phone);

    Optional<EmployeeEntity> findByEmailAndPhone(String email, String phone);

    @Query(value = "select * from employee  where salary >?",nativeQuery = true)
    List<EmployeeEntity> findGreaterSalaryByCondation(String salary);

    @Query(value = "select * from employee  where salary <?",nativeQuery = true)
    List<EmployeeEntity> findLessSalaryByCondation(String salary);

    List<EmployeeEntity> findBySalary(String salary);

}
