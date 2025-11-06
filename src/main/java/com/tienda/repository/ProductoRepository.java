/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.tienda.repository;

import com.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productorepository extends JpaRepository<Producto, Integer> {
}