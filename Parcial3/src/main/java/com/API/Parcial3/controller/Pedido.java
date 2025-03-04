package com.API.Parcial3.controller;

import com.API.Parcial3.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String id;
    private String cliente;
    private List<Producto> productos = new ArrayList<>(); // Evita valores null
    private double total;

    public void calcularTotal() {
        this.total = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void setProductosObj(List<Producto> productos) {
        this.productos = productos;
        calcularTotal(); // Recalcula el total cada vez que se actualiza la lista de productos
    }
}

