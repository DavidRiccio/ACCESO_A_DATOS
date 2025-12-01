package com.pratica1.persistence.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratica1.domain.model.Department;
import com.pratica1.repo.IDepartmentRepository;
import com.pratica1.repo.jpa.IDepartmentJpaRespository;

import jakarta.transaction.Transactional;

public class DepartmentJpaImpl implements IDepartmentRepository {

    @Autowired
    IDepartmentJpaRespository jpaRepository;

    @Override
    @Transactional
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    @Transactional

    public Optional<Department> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    @Transactional
    public Department save(Department department) {
        return jpaRepository.save(department);
    }

    @Override
    @Transactional

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

}
