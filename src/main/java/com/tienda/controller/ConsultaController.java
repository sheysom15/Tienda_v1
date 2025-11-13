package com.tienda.controller;

import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsultaController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/consulta/productos")
    public String consultaProductos(
            @RequestParam(name = "min", required = false, defaultValue = "0") double min,
            @RequestParam(name = "max", required = false, defaultValue = "999999") double max,
            @RequestParam(name = "categoria", required = false, defaultValue = "") String categoria,
            Model model) {

        var lista = productoService.buscarPorPrecioYCategoria(min, max, categoria);

        model.addAttribute("productos", lista);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("categoria", categoria);
        model.addAttribute("total", lista.size());

        return "/consulta/listado";
    }
}
