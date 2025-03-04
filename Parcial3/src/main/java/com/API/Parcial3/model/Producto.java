package com.API.Parcial3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // ¡Esta anotación es clave!
public class Producto {
    private String id;
    private String nombre;
    private double precio;
}