package com.wadajo.clima.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wadajo.clima.domain.dto.aemet.response.PrediccionHorariaInternalResponseDto;
import com.wadajo.clima.domain.dto.response.PrediccionHorariaResponseDto;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.ConversionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ClimaGraphqlController {

    private final ClimaExternalClient climaExternalClient;
    private final ClimaInternalClient climaInternalClient;
    private final ConversionService cs;
    private static final Logger LOGGER = LogManager.getLogger(ClimaGraphqlController.class);

    public ClimaGraphqlController(ClimaExternalClient climaExternalClient, ClimaInternalClient climaInternalClient, ConversionService cs) {
        this.climaExternalClient = climaExternalClient;
        this.climaInternalClient = climaInternalClient;
        this.cs = cs;
    }


    @QueryMapping
    PrediccionHorariaResponseDto prediccionHoraria (@Argument String codMunicipio) {
        var wrapper= climaExternalClient.getPrediccionHorariaWrapper(codMunicipio);
        LOGGER.log(Level.DEBUG,wrapper);
        if (wrapper.estado()==200){
            LOGGER.log(Level.DEBUG,"Datos en: "+wrapper.datos());

            var prediccionHorariaRaw=climaInternalClient.getPrediccionHorariaRaw(wrapper.datos().substring(38));
            LOGGER.log(Level.DEBUG,"Resultado client RAW: "+prediccionHorariaRaw);

            ObjectMapper rawStringObjectMapper=new ObjectMapper();
            try {
                var prediccionHorariaTrim=prediccionHorariaRaw.substring(1,prediccionHorariaRaw.lastIndexOf("]")).trim();
                var resultInternal=rawStringObjectMapper.readValue(prediccionHorariaTrim, PrediccionHorariaInternalResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client parseada: "+resultInternal);

                var result=cs.convert(resultInternal,PrediccionHorariaResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client final mapeada: "+result);
                return result;

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
