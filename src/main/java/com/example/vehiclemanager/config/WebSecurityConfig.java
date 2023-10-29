package com.example.vehiclemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /*
         * By default, Spring Security disables rendering within an iframe because
         * allowing a webpage to be added to a frame can be a security issue,
         * for example Clickjacking. Since H2 console runs within a frame so while Spring security is enabled,
         * frame options has to be disabled explicitly, in order to get the H2 console working.
         */
        http.headers().frameOptions().disable();
        return http.build();
    }
}
