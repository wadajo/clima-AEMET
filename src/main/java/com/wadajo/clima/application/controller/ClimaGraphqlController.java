package com.wadajo.clima.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

            var prediccionHorariaRaw=climaInternalClient.getPrediccionHorariaRaw(wrapper.datos().substring(38));
            LOGGER.atDebug().log("Resultado client RAW: "+prediccionHorariaRaw);

            ObjectMapper mapper=new ObjectMapper();
            try {
                var prediccionHorariaTrim=prediccionHorariaRaw.substring(1,prediccionHorariaRaw.lastIndexOf("]")).trim();
                var result=mapper.readValue(prediccionHorariaTrim, PrediccionHorariaInternalResponseDto.class);
                LOGGER.atDebug().log("Resultado client parseada: "+result);

                //TODO con mapstruct convertir en un objeto de salida más ameno para GraphQL
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
