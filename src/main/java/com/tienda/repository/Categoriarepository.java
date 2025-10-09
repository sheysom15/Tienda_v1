/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.tienda.repository;

import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoriarepository extends JpaRepository<Categoria, Integer> {
}