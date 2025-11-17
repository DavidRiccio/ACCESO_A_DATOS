package com.pratica1.repo;

import java.util.Optional;

import com.pratica1.domain.model.Department;

public interface IDepartmentRepository {
    boolean existsById(Long id);
    Optional<Department> findById(Long id);
    Department save(Department department);
    void deleteById(Long id);

}
