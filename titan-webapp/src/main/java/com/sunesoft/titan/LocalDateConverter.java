package com.sunesoft.titan;

import org.springframework.core.convert.converter.Converter;
 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
public final class LocalDateConverter implements Converter<String, LocalDate> {
 
    private final DateTimeFormatter formatter= DateTimeFormatter.ISO_DATE;
 
    public LocalDateConverter() {

    }
 
    @Override
    public LocalDate convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
 
        return LocalDate.parse(source, formatter);
    }
}