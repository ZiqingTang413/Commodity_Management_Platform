package com.example.helloworld.config;

import com.example.helloworld.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // valid only for "/user/**"
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}
