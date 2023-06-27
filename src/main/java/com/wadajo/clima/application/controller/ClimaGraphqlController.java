package com.wadajo.clima.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wadajo.clima.domain.dto.response.PrediccionHorariaInternalResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.http.MediaType.TEXT_PLAIN;

@Controller
public class ClimaGraphqlController {

    private final ClimaExternalClient climaExternalClient;
    private final ClimaInternalClient climaInternalClient;
    private static final Logger LOGGER = LogManager.getLogger();

    public ClimaGraphqlController(ClimaExternalClient climaExternalClient, ClimaInternalClient climaInternalClient) {
        this.climaExternalClient = climaExternalClient;
        this.climaInternalClient = climaInternalClient;
    }


    @QueryMapping
    PrediccionHorariaInternalResponseDto prediccionHoraria (@Argument String codMunicipio){
        var wrapper= climaExternalClient.getPrediccionHorariaWrapper(codMunicipio);
        LOGGER.atInfo().log(wrapper);
        if (null!=wrapper.datos()){
            var location=wrapper.datos().substring(38);
            LOGGER.atInfo().log(location);

            var prediccion = WebClient.builder()
                    .baseUrl("https://opendata.aemet.es/opendata/sh/"+location)
                    .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                    .build()
                    .get()
                    .retrieve()
                    .bodyToMono(List.class);



//            var prediccion= climaInternalClient.getPrediccionHoraria(location);
            LOGGER.atInfo().log("Localidad: "+prediccion.block().size());
        }
        return null;
    }
    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        clientCodecConfigurer.customCodecs().encoder(new Jackson2JsonEncoder(new ObjectMapper(), TEXT_PLAIN));
        clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder(new ObjectMapper(), TEXT_PLAIN));
    }

}
