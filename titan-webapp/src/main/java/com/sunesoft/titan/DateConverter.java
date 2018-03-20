package com.sunesoft.titan;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@Component
public class DateConverter implements WebBindingInitializer {
    public DateConverter() {
    }

    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(LocalDate.class, new CustomLocalDateEditor());
    }
}