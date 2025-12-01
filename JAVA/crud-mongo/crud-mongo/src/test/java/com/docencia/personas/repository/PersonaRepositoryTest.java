package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private PersonaRepository personaRepository;
    private Persona personaColection;
    private Direccion direccion;
    private Persona personaFind;
    private String email = "pepe1@gmail.com";
    private String ciudad = "Santa Cruz de Tenerife";

    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBAse() {
        personaRepository.deleteAll();
        direccion = new Direccion("calle", ciudad, "38107", "Espania");
        personaColection = new Persona("test", 18, email, direccion);
        personaFind = personaRepository.save(personaColection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1, personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }

    @Test
    void testFindByCiudad() {
        List<Persona> personas = personaRepository.findByCiudad(ciudad);
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getDireccion());
        Assertions.assertNotNull(persona.getDireccion().getCiudad());
        Assertions.assertEquals(ciudad, persona.getDireccion().getCiudad());
    }

    @Test
    void testFindByEdadBetween() {
        List<Persona> personas = personaRepository.findByEdadBetween(10, 20);
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getEdad());
        Assertions.assertEquals(persona.getEdad(), personaFind.getEdad());

    }

    @Test
    void testFindByEmail() {
        Optional<Persona> personaOptional = personaRepository.findByEmail(email);
        Persona persona = personaOptional.get();
        Assertions.assertEquals(email, persona.getEmail());
        Assertions.assertNotNull(persona.getEmail());
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {
        List<Persona> personas = personaRepository.findByNombreContainingIgnoreCase("TEST");
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getNombre());
        Assertions.assertEquals(personaFind.getNombre(), persona.getNombre());

    }

}
