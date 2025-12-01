package com.docencia.rest.service.interfaces;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.model.User;

/**
 * Interfaz de Usuario
 * 
 * @author DavidRiccio
 * @version 1.0.0
 */
public interface UserServiceInterface {
    /**
     * Lista los usuarios
     * 
     * @return Lista de los User
     */
    public List<User> getAllUsers();

    /**
     * Encuentra un usuario por su id
     * 
     * @param userId Id del usuario
     * @return Usuario con la id establecida.
     * @throws ResourceNotFoundException
     */
    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

    /**
     * Crea un usuario
     * 
     * @param user Usuario que se quiere crear
     * @return El usuario creado
     */
    public User createUser(@Validated @RequestBody User user);

    /**
     * Actualiza un usuario
     * 
     * @param userId      Usuario a actualiazr
     * @param userDetails campos a actualizar
     * @return El usuario actualizado
     * @throws ResourceNotFoundException
     */
    public User updateUser(@PathVariable(value = "id") int userId,
            @Validated @RequestBody User userDetails) throws ResourceNotFoundException;

    /**
     * Elimina un usuario
     * 
     * @param userId usuario a eliminar
     * @return true si se ha borrado correctamente
     * @throws ResourceNotFoundException
     */
    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;
}
