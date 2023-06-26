package com.wadajo.clima.infrastructure.config;


import com.wadajo.clima.application.controller.ClimaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Bean
    WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://opendata.aemet.es/opendata/sh")
                .build();
    }
    @Bean
    ClimaClient climaClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient()))
                        .build();
        return httpServiceProxyFactory.createClient(ClimaClient.class);
    }
}

