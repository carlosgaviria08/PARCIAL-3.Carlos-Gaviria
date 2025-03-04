package com.API.Parcial3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return messageSource.getMessage(key, null, locale);
    }
}

