package com.pratica1.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica1.domain.model.Department;

public interface IDepartmentJpaRespository extends JpaRepository<Department, Long> {
    
}
