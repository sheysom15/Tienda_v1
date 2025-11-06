/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @Column(columnDefintion = "TEXT")
    private String detalle;
    
    @Column(precision = 12,  scale = 2)
    private BigDecimal precio;
    
    //@NotNull(message = "El campo de existencia no puede estar vacio")
    private Integer existencias; 
    
    
    @Column(length = 1024)
    private String rutaImagen;

    @Column(name = "activo")
    private Boolean activo;
    
    @ManyToOne
    @Joincolumn(name "id_categoria")
    privateCategoria categoria
}