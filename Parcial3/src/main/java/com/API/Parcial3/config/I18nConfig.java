package com.API.Parcial3.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Locale;

@Configuration
public class I18nConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    public static Locale getLocale(ServerRequest request) {
        return request.headers()
                .header("Accept-Language")
                .stream()
                .findFirst()
                .map(Locale::forLanguageTag)
                .orElse(Locale.getDefault());
    }
}
