package com.wadajo.clima.infrastructure.config;


import com.wadajo.clima.application.controller.ClimaExternalClient;
import com.wadajo.clima.application.controller.ClimaInternalClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClimaClientConfig {

    @Value("${api-key}")
    private String API_KEY;

    @Bean
    WebClient webClientExternal() {
        return WebClient.builder()
                .baseUrl("https://opendata.aemet.es/opendata/api")
                .defaultHeader("api_key",API_KEY)
                .defaultHeader("accept","application/json")
                .build();
    }
    @Bean
    ClimaExternalClient climaExternalClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(
                        WebClientAdapter.forClient(webClientExternal()))
                        .build();
        return httpServiceProxyFactory.createClient(ClimaExternalClient.class);
    }

    @Bean
    WebClient webClientInternal() {
        return WebClient.builder()
                .baseUrl("https://opendata.aemet.es/opendata/sh")
                .build();
    }
    @Bean
    ClimaInternalClient climaInternalClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(
                                WebClientAdapter.forClient(webClientInternal()))
                        .build();
        return httpServiceProxyFactory.createClient(ClimaInternalClient.class);
    }
}

