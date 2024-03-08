package com.ems.leave_service.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DepartmentRestClientFactory {
    private final ObjectMapper objectMapper;

//    @Bean
//    public ZooStoreRestClient getRestExportClient() {
//        return Feign.builder()
//                .encoder(new JacksonEncoder(objectMapper))
//                .decoder(new JacksonDecoder(objectMapper))
//                .target(ZooStoreRestClient.class, "http://localhost:8081");
//    }
}
