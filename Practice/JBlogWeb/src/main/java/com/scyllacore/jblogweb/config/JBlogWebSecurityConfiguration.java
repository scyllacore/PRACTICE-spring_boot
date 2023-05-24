package com.scyllacore.jblogweb.config;

import com.scyllacore.jblogweb.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JBlogWebSecurityConfiguration {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception{
        return auth.getAuthenticationManager();
    }

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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
