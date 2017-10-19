package com.ms.cashloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.*;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import java.util.*;
import org.springframework.http.converter.HttpMessageConverter;
/**
 * Created by wuketao on 2017/10/19.
 */
@Configuration
public class AppConfig {

    @Bean
    public AnnotationMethodHandlerAdapter getAnnotationMethodHandlerAdapter(){
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter[] hmc = new HttpMessageConverter[2];
        hmc[0] = stringHttpMessageConverter;
        hmc[1] = formHttpMessageConverter;
        AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
        adapter.setMessageConverters(hmc);
        return adapter;
    }
}
