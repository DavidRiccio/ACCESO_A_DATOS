package com.docencia.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}