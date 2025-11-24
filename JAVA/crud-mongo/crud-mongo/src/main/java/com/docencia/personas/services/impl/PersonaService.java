package com.docencia.personas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;
import com.docencia.personas.services.IPersonaService;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(String id) {
        return personaRepository.findById(id).get();

    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean deleteById(String id) {
        personaRepository.deleteById(id);
        return true;
    }

}