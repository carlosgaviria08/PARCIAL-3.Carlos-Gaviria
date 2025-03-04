package com.API.Parcial3.service;

import com.API.Parcial3.model.Pedido;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PedidoService {
    private final CopyOnWriteArrayList<Pedido> pedidos = new CopyOnWriteArrayList<>();

    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido.inicializarPedido(); // Genera ID y fecha
        pedidos.add(pedido);
        return Mono.just(pedido);
    }

    public Flux<Pedido> listarPedidos() {
        return Flux.fromIterable(pedidos);
    }
}