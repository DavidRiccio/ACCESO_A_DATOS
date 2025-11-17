package com.pratica1.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

import io.micrometer.common.lang.NonNull;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @NonNull
    @Column(name = "employee_id")
    Long id ;


    @Column(name="name")
    @NonNull
    String name ;

    @Column(name="email")
    @NonNull
    String email;

    @Column(name="salary")
    float salary;

    @Column(name="department_id")
    @ManyToOne
    Department department;

    public Employee() {
    }
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Employee(Long id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee id(Long id) {
        setId(id);
        return this;
    }

    public Employee name(String name) {
        setName(name);
        return this;
    }

    public Employee salary(float salary) {
        setSalary(salary);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}