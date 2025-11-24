package com.docencia.personas.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;

public class PersonaServiceTest {

    @Autowired
    PersonaRepository personaRepository;


    @Autowired 
    PersonaService personaService;

     public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    private Persona personaColection;
    private Direccion direccion;
    private String email = "pepe1@gmail.com";
    private String ciudad = "Santa Cruz de Tenerife";


     @BeforeEach
    void cleanDataBAse() {
        personaRepository.deleteAll();
        direccion = new Direccion("calle", ciudad, "38107", "Espania");
        personaColection = new Persona("test", 18, email, direccion);
    }

    @Test
    void testFind(){
    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
