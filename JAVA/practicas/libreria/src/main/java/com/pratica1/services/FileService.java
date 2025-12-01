package com.pratica1.services;


import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pratica1.domain.model.Employee;

@Service
public class FileService {

    private final ObjectMapper jsonMapper;
    private final XmlMapper xmlMapper;

    public FileService() {
        this.jsonMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();

        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    // -------------------------
    // EXPORTAR LISTA A JSON
    // -------------------------
    public void writeEmployeesToJson(List<Employee> employees, String path) throws Exception {
        jsonMapper.writeValue(new File(path), employees);
    }

    // -------------------------
    // EXPORTAR LISTA A XML
    // -------------------------
    public void writeEmployeesToXml(List<Employee> employees, String path) throws Exception {
        xmlMapper.writeValue(new File(path), employees);
    }

    // -------------------------
    // IMPORTAR EMPLEADO DESDE JSON
    // -------------------------
    public Employee readEmployeeFromJson(String path) throws Exception {
        return jsonMapper.readValue(new File(path), Employee.class);
    }

    // -------------------------
    // IMPORTAR EMPLEADO DESDE XML
    // -------------------------
    public Employee readEmployeeFromXml(String path) throws Exception {
        return xmlMapper.readValue(new File(path), Employee.class);
    }
}
