package com.shop.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : WangYB
 * @time: 2020/11/10  16:43
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/address/*");
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/cart/*");
    }

    @Bean
    public AddressInterceptor authenticationInterceptor() {
        return new AddressInterceptor();
    }

}

