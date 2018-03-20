package com.sunesoft.titan;

import com.sunesoft.titan.common.utils.StringUtil;
import org.springframework.core.MethodParameter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateResolver implements HandlerMethodArgumentResolver {
    public LocalDateResolver() {
    }
    private final DateTimeFormatter formatter =DateTimeFormatter.ISO_DATE;
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LocalDate.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        LocalDate obj = null;
        String name = parameter.getParameterName();
        String parameter2 = webRequest.getParameter(name);

        try {
            if (StringUtil.isEmpty(parameter2)) {
                return null;
            } else {
                obj = LocalDate.parse(parameter2,formatter);
                return obj;
            }
        } catch (Exception var9) {
            return null;
        }
    }
}