package com.crayon.kk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @author 75510
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurationSupport {

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/403");
        addInterceptor.excludePathPatterns("/toLogin");
        addInterceptor.excludePathPatterns("/login**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}