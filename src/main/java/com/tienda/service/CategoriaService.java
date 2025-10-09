package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.Categoriarepository; // ← aquí con r minúscula
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private Categoriarepository categoriaRepository; // ← también con r minúscula
    
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var lista = categoriaRepository.findAll();
        if (activo) {
            lista.removeIf(e -> !e.getActivo());
        }
        return lista;
    }
}
