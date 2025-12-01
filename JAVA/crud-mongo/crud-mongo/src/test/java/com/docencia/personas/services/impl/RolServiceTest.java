package com.docencia.personas.services.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRolService;

@SpringBootTest
public class RolServiceTest {

    private static final String ROL_NOMBRE = "Rol nombre";
    private static final String ROL_1 = "ROL-1";
    IRolService rolService;
    Rol rol;

    @Autowired
    public void setRolService(IRolService rolService) {
        this.rolService = rolService;
    }

    @BeforeEach
    void beforeEach() {
        if (rol == null) {
            rol = new Rol(ROL_1, ROL_NOMBRE);
        }
        rolService.save(rol);
    }

    @AfterEach
    void afterEach() {
        Rol rolDelete = new Rol(ROL_1);
        rolService.delete(rolDelete);
        rolDelete = rolService.findBy(rolDelete);
        Assertions.assertNull(rolDelete);
    }

    @Test
    void testfindBy() {
        Rol rolFind = new Rol(ROL_1);
        rolFind = rolService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(ROL_1, rolFind.getId());
        Assertions.assertEquals(rol, rolFind);
        Assertions.assertEquals(ROL_NOMBRE, rolFind.getNombre());
    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindBy() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
