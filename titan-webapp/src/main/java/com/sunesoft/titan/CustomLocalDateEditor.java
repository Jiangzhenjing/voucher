package com.sunesoft.titan;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class CustomLocalDateEditor extends PropertyEditorSupport {

    private final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void setAsText(String text) throws IllegalArgumentException {
        if ( !StringUtils.hasText(text)) {
            this.setValue((Object)null);
        } else {
            if (text != null  && text.length() != 10) {
                throw new IllegalArgumentException("Could not parse date: it is not exactly" + 10 + "characters long,like yyyy-MM-dd");
            }

            this.setValue( LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
        }

    }

    public String getAsText() {
        LocalDate value = (LocalDate)this.getValue();
        return value != null ? value.format(formatter) : "";
    }
}
