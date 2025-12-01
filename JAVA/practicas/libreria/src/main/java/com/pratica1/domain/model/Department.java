package com.pratica1.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

import io.micrometer.common.lang.NonNull;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @NonNull
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "location")
    @NonNull
    String location;
    @OneToMany
    @Column(name = "employees")
    List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department id(Long id) {
        setId(id);
        return this;
    }

    public Department name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Department)) {
            return false;
        }
        Department department = (Department) o;
        return Objects.equals(id, department.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
