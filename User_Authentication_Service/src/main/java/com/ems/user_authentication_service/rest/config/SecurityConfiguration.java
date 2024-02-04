package com.ems.user_authentication_service.rest.config;

import com.ems.user_authentication_service.core.auth.ApplicationUserDetailsService;
import com.ems.user_authentication_service.persistence.repositories.UserRepository;
import com.ems.user_authentication_service.rest.secutity.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
    private final UserRepository userRepository;
    //private final JwtFilter jwtFilter;

    @Bean
    public UserDetailsService getApplicationUserDetailsService() {
        return new ApplicationUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

