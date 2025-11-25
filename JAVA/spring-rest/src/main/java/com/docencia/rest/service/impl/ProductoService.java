package com.docencia.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.rest.model.Producto;
import com.docencia.rest.repo.ProductoRepository;
import com.docencia.rest.service.interfaces.ProductoServiceInterface;

@Service
public class ProductoService implements ProductoServiceInterface {
    private ProductoRepository productoRepository;

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<Producto> findById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Optional<Producto> find(Producto producto) {
        return findById(producto.getId());
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean deleteById(int id) {
        Producto producto1 = new Producto(1);
        return  delete(producto1);
    }

    @Override
    public boolean delete(Producto producto) {
       productoRepository.delete(producto);
       return true;
    }

}
