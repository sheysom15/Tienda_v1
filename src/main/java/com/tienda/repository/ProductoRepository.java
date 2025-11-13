/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.tienda.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    // JpaRepository -> CRUD + Consultas a la BD (SELECT, DELETE, LIST)

    // JPA Ampliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Query -> Lista de productos que esten en el rango de precioInf y precioSup
    //        -> Ordenar por su Descripcion

    // JPA Ampliada
    // Metodo utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
   
   // Consulta ampliada personalizada
@Query("""
       SELECT p 
       FROM Producto p 
       WHERE p.precio BETWEEN :min AND :max
       AND (:categoria = '' OR p.categoria.descripcion LIKE %:categoria%)
       ORDER BY p.descripcion ASC
       """)
public List<Producto> buscarPorPrecioYCategoria(
        @Param("min") double min, 
        @Param("max") double max, 
        @Param("categoria") String categoria);

}
