package com.API.Parcial3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Locale;

@RestController
public class SaludoController {

    @GetMapping("/api/saludo")
    public ResponseEntity<String> saludo(@RequestParam(value = "lang", required = false) String lang,
                                         ServerWebExchange exchange) {
        Locale locale;

        if (lang != null && !lang.isEmpty()) {
            locale = Locale.forLanguageTag(lang);
        } else {
            locale = exchange.getRequest().getHeaders().getAcceptLanguageAsLocales().stream()
                    .findFirst()
                    .orElse(Locale.getDefault());
        }

        String mensaje;
        if (locale.getLanguage().equals("es")) {
            mensaje = "Hola, bienvenido a nuestra API Reactiva!";
        } else if (locale.getLanguage().equals("fr")) {
            mensaje = "Bonjour, bienvenue sur notre API réactive!";
        } else {
            mensaje = "Hello, welcome to our Reactive API!";
        }

        return ResponseEntity.ok(mensaje);
    }
}