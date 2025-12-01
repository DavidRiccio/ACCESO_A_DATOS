package com.pratica1;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratica1.domain.model.Department;
import com.pratica1.domain.model.Employee;
import com.pratica1.services.FileService;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ------------------------------------------------------------
        // 1. CREAR DATOS
        // ------------------------------------------------------------
        Department it = new Department(1L, "IT");
        Department hr = new Department(2L, "HR");

        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Ana Torres", 2200),
                new Employee(2L, "Luis Pérez", 1800),
                new Employee(3L, "Marta Díaz", 2500));

        // ------------------------------------------------------------
        // 2. EXPORTAR JSON / XML
        // ------------------------------------------------------------
        fileService.writeEmployeesToJson(employees, "employees.json");
        fileService.writeEmployeesToXml(employees, "employees.xml");

        System.out.println("Exportados: employees.json y employees.xml");

        // ------------------------------------------------------------
        // 3. IMPORTAR DESDE JSON
        // ------------------------------------------------------------
        // Employee imported = fileService.readEmployeeFromJson("employee_new.json");
        // System.out.println("Empleado importado desde JSON:");
        // System.out.println(imported);

        // ------------------------------------------------------------
        // 4. IMPORTAR DESDE XML
        // ------------------------------------------------------------
        // Employee importedXml = fileService.readEmployeeFromXml("employee_new.xml");
        // System.out.println("Empleado importado desde XML:");
        // System.out.println(importedXml);
    }
}
