package com.API.Parcial3.config;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import java.util.Locale;

public class CustomAcceptHeaderLocaleContextResolver extends AcceptHeaderLocaleContextResolver {

    @Override
    public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
        // Obtén el valor del header "Accept-Language"
        String headerLang = exchange.getRequest().getHeaders().getFirst("Accept-Language");
        Locale locale;
        if (headerLang != null && !headerLang.isEmpty()) {
            // Separa la cadena por comas y toma el primer valor (por ejemplo, "es-419")
            String primaryLang = headerLang.split(",")[0].trim();
            try {
                // Usa Locale.forLanguageTag para crear el Locale correctamente
                locale = Locale.forLanguageTag(primaryLang);
            } catch (Exception e) {
                // Si ocurre un error, usa el Locale por defecto configurado
                locale = getDefaultLocale();
            }
        } else {
            locale = getDefaultLocale();
        }
        // Asegúrate de usar la clase SimpleLocaleContext que implemente LocaleContext correctamente
        return new SimpleLocaleContext(locale);
    }
}