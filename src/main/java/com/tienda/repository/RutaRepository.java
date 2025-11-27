package com.tienda.repository;

import com.tienda.domain.Ruta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    List<Ruta> findAllByOrderByRequiereRolAsc();
}