package com.forexservice.ForexService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Map this to your API endpoints
                        .allowedOrigins("http://localhost:4200") // Specify the allowed origin(s)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
                        .allowCredentials(true); // Allow cookies and authentication headers
            }
        };
    }
}
