package com.ems.user_authentication_service.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean
    Logger getLogger(){
        return LoggerFactory.getLogger("logger");
    }
}
