package com.API.Parcial3.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Pedido {
    private String id;

    @NotBlank(message = "{cliente.requerido}")
    private String cliente;

    @NotNull(message = "{productos.requeridos}")
    private List<Producto> productos;

    @PositiveOrZero(message = "{total.invalido}")
    private double total;

    private LocalDateTime fecha;

    // Constructor para crear pedidos manualmente (sin ID ni fecha)
    public Pedido(String cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        calcularTotal(); // Calcula el total, pero no genera ID ni fecha
    }

    // Método para inicializar ID y fecha ANTES de guardar el pedido
    public void inicializarPedido() {
        this.id = UUID.randomUUID().toString();
        this.fecha = LocalDateTime.now();
    }

    public void calcularTotal() {
        this.total = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }
}