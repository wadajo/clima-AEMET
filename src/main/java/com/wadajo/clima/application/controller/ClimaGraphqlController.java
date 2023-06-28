package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaInternalResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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
    PrediccionHorariaInternalResponseDto prediccionHoraria (@Argument String codMunicipio) {
        var wrapper= climaExternalClient.getPrediccionHorariaWrapper(codMunicipio);
        LOGGER.atInfo().log(wrapper);
        if (wrapper.estado()==200){
            LOGGER.atInfo().log("Datos en: "+wrapper.datos());

            var result=climaInternalClient.getPrediccionHorariaRaw(wrapper.datos().substring(38));

            LOGGER.atInfo().log("Resultado client: "+result);
        }
        return null;
    }

}
