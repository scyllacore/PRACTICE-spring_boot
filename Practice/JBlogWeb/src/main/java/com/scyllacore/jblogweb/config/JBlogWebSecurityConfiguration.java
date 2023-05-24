package com.scyllacore.jblogweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JBlogWebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/post/**").authenticated();
        http.authorizeHttpRequests().anyRequest().permitAll();

        http.csrf().disable();

        http.formLogin().loginPage("/auth/login");
        http.formLogin().loginProcessingUrl("/auth/securitylogin");
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");

        return http.build();
    }
}