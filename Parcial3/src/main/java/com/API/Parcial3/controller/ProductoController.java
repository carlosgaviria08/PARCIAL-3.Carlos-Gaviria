package com.API.Parcial3.controller;

import com.API.Parcial3.model.Producto;
import com.API.Parcial3.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService; // ✅ Inyección correcta
    }

    @GetMapping
    public Flux<Producto> listarProductos() {
        return productoService.listarProductos(); // Ahora el método existe
    }
}