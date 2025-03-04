package com.API.Parcial3.controller;

import com.API.Parcial3.model.Pedido;
import com.API.Parcial3.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Locale;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping
    public Mono<ResponseEntity<String>> crearPedido(
            @RequestBody Pedido pedido,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        pedido.calcularTotal();
        return pedidoService.crearPedido(pedido)
                .map(p -> ResponseEntity.ok(
                        messageSource.getMessage("pedido.creado", null, locale)
                ));
    }

    @GetMapping
    public Flux<Pedido> listarPedidos(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        return pedidoService.listarPedidos()
                .doOnNext(p -> System.out.println(
                        messageSource.getMessage("pedido.lista", null, locale)
                ));
    }
}
