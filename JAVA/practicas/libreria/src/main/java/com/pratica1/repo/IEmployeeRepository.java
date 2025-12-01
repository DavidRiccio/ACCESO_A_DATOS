package com.pratica1.repo;


import java.util.List;
import java.util.Optional;

import com.pratica1.domain.model.Employee;

public interface IEmployeeRepository {
    boolean exixtsById(Long id);
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
    List<Employee> findBySalaryGreaterThan(float salary);
    
}