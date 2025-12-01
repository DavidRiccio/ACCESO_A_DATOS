package com.pratica1.repo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pratica1.domain.model.Employee;

public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1") List<Employee> findBySalaryGreaterThan(float salary);

    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
    List<Employee> findByDepartmentId(Long departmentId);
}
