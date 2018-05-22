package com.spstudio.springsecuritydemo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cc = CacheControl
                .maxAge(1, TimeUnit.HOURS)
                .cachePublic();
                
        registry
            .addResourceHandler("/img/**")
            .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/img/")
            .setCacheControl(cc);
        
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
