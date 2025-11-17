package com.pratica1.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratica1.domain.model.Employee;
import com.pratica1.repo.IEmployeeRepository;
import com.pratica1.repo.jpa.IEmployeeJpaRepository;

public class EmployeeJpaImpl implements IEmployeeRepository {

    @Autowired

    IEmployeeJpaRepository jpaRepository;

    @Override
    public boolean exixtsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return jpaRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(float salary) {
        return jpaRepository.findBySalaryGreaterThan(salary);
    }

}
