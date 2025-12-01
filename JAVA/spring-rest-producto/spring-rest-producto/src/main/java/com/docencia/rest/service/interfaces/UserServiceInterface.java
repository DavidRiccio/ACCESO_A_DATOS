package com.docencia.rest.service.interfaces;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.modelo.User;

public interface UserServiceInterface {
    /**
     *Lista todos los usuarios de la base de datos
     * @return lista de usuarios
     */
    public List<User> getAllUsers();

    /**
     * Busca un usuario a traves de su id
     * @param userId id del usuario que quieres buscar
     * @return el usuario que buscaste
     * @throws ResourceNotFoundException si no lo encuentra
     */
    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

    /**
     * Guarda un usuario en la base de datos
     * @param user usuario que quieres guardar
     * @return el usuario que guardaste
     */
    public User createUser(@Validated @RequestBody User user);

    /**
     * Actualiza un usuario en la base de datos
     * @param userId id del usuario que quieres actualizar
     * @param userDetails detalles del usuario que quieres actualizar
     * @return el usuario que actualizaste
     * @throws ResourceNotFoundException si no lo encuentra
     */
    public User updateUser(@PathVariable(value = "id") int userId,
            @Validated @RequestBody User userDetails) throws ResourceNotFoundException;

    /**
     * Borra un usuario de la base de datos
     * @param userId id del usuario que quieres borrar
     * @return true si lo borraste
     * @throws ResourceNotFoundException si no lo encuentra
     */
    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

}
