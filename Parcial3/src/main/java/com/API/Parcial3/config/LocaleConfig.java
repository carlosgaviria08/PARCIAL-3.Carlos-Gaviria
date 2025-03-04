package com.API.Parcial3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.i18n.LocaleContextResolver;
import java.util.Locale;
import java.util.List;

@Configuration
public class LocaleConfig {

    @Bean
    public LocaleContextResolver localeResolver() {
        CustomAcceptHeaderLocaleContextResolver resolver = new CustomAcceptHeaderLocaleContextResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        // Define los locales soportados
        resolver.setSupportedLocales(List.of(
                Locale.ENGLISH,
                new Locale("es"),
                new Locale("es", "419")
        ));
        return resolver;
    }
}
