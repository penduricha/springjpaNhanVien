package com.example.springjpa.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CorsFilterConfig implements WebMvcConfigurer {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.GET, DispatcherType.valueOf("/**")).permitAll()  // Cho phép GET mà không cần xác thực
                .dispatcherTypeMatchers(HttpMethod.POST, DispatcherType.valueOf("/**")).permitAll() // Cho phép POST mà không cần xác thực
                .dispatcherTypeMatchers(HttpMethod.PUT, DispatcherType.valueOf("/**")).permitAll()  // Cho phép PUT mà không cần xác thực
                .dispatcherTypeMatchers(HttpMethod.DELETE, DispatcherType.valueOf("/**")).permitAll() // Cho phép DELETE mà không cần xác thực
                .anyRequest().authenticated()
                .and()
                .formLogin(withDefaults()); // Cấu hình form login mặc định
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.build();
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:63342")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}