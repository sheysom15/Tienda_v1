package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.Productorepository; // ← aquí con r minúscula
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    private Productorepository productoRepository; // ← también con r minúscula
    
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoRepository.findAll();
        if (activo) {
            lista.removeIf(e -> !e.getActivo());
        }
        return lista;
    }
@Transactional
public void save(Producto producto) {
    productoRepository.save(producto);
    
}
    
@Transactional
public boolean delete(Producto producto) {
    try {
        productoRepository.delete(producto);
        productoRepository.flush();
        return true;
    } catch (Exception e) {
        System.err.println("Error al eliminar la categoría: " + e.getMessage());
        return false;
    }
}

@Transactional(readOnly = true)
public Producto getProducto(Producto producto) {
    

    return productoRepository.findById(producto.getIdProducto()).orElse(null);
}
 }
