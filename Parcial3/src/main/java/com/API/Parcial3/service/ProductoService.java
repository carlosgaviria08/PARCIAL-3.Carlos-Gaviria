package com.API.Parcial3.service;

import com.API.Parcial3.model.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductoService {
    private final Map<String, Producto> productosDB = new ConcurrentHashMap<>();

    public ProductoService() {
        productosDB.put("1", new Producto("1", "Laptop", 1200.0));
        productosDB.put("2", new Producto("2", "Mouse", 25.0));
        productosDB.put("3", new Producto("3", "Teclado", 45.0));
    }

    // ✅ Método para listar todos los productos
    public Flux<Producto> listarProductos() {
        return Flux.fromIterable(productosDB.values());
    }

    public Mono<Producto> obtenerProductoPorId(String id) {
        return Mono.justOrEmpty(productosDB.get(id));
    }
}