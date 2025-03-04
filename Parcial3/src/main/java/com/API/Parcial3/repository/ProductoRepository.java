package com.API.Parcial3.repository;

import com.API.Parcial3.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, String> {
    Flux<Producto> findAll();
}
