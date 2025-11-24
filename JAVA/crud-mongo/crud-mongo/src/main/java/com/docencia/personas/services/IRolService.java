package com.docencia.personas.services;

import java.util.List;

import com.docencia.personas.model.Rol;

public interface IRolService {
   public List<Rol> findAll();
    public Rol save(Rol rol);
    public boolean delete(Rol rol);
    public Rol findBy(Rol rol);
}
