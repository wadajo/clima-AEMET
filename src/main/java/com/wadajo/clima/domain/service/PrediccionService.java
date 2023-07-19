package com.wadajo.clima.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.wadajo.clima.application.controller.ClimaExternalClient;
import com.wadajo.clima.application.controller.ClimaInternalClient;
import com.wadajo.clima.domain.dto.aemet.response.PrediccionHorariaInternalResponseDto;
import com.wadajo.clima.domain.dto.aemet.response.PrediccionJornadaInternalResponseDto;
import com.wadajo.clima.domain.dto.response.PrediccionDto;
import com.wadajo.clima.domain.dto.response.PrediccionHorariaResponseDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaResponseDto;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class PrediccionService {

    private final ClimaExternalClient climaExternalClient;
    private final ClimaInternalClient climaInternalClient;
    private final ConversionService cs;
    private static final Logger LOGGER = LogManager.getLogger(PrediccionService.class);

    public PrediccionService (ClimaExternalClient climaExternalClient, ClimaInternalClient climaInternalClient, ConversionService cs) {
        this.climaExternalClient = climaExternalClient;
        this.climaInternalClient = climaInternalClient;
        this.cs = cs;
    }

    @Cacheable("horaria")
    public PrediccionHorariaResponseDto getPrediccionHorariaResponseDto(String codMunicipio) {
        var wrapper= climaExternalClient.getPrediccionHorariaWrapper(codMunicipio);
        LOGGER.log(Level.DEBUG,wrapper);
        if (wrapper.getStatusCode().is2xxSuccessful() &&
                Objects.requireNonNull(wrapper.getBody()).estado()==200){
            var wrapperBody=wrapper.getBody();
            LOGGER.log(Level.DEBUG,"Datos en: "+wrapperBody.datos());

            var prediccionRaw=climaInternalClient.getPrediccionRaw(wrapperBody.datos().substring(38));
            LOGGER.log(Level.DEBUG,"Resultado client RAW: "+prediccionRaw);

            ObjectMapper rawStringObjectMapper=new ObjectMapper();
            try {
                var prediccionHorariaTrim=prediccionRaw.substring(1,prediccionRaw.lastIndexOf("]")).trim();
                var resultInternal=rawStringObjectMapper.readValue(prediccionHorariaTrim, PrediccionHorariaInternalResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client parseada: "+resultInternal);

                var result=cs.convert(resultInternal,PrediccionHorariaResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client final mapeada: "+result);
                return result;

            } catch (JsonProcessingException e) {
                LOGGER.log(Level.ERROR,"Error procesando el mensaje interno: "+e.getMessage());
                return new PrediccionHorariaResponseDto("N/A", "N/A", "N/A", new PrediccionDto((Collections.emptyList())));
            }
        }
        LOGGER.log(Level.ERROR,"Error al intentar conectar con la API. Cod respuesta: "+wrapper.getStatusCode());
        return new PrediccionHorariaResponseDto("N/A", "N/A", "N/A", new PrediccionDto((Collections.emptyList())));
    }

    @Cacheable("diaria")
    public PrediccionJornadaResponseDto getPrediccionJornadaResponseDto (String codMunicipio) {
        var wrapper= climaExternalClient.getPrediccionDiariaWrapper(codMunicipio);
        LOGGER.log(Level.DEBUG,wrapper);
        if (wrapper.getStatusCode().is2xxSuccessful() &&
                Objects.requireNonNull(wrapper.getBody()).estado()==200){
            var wrapperBody=wrapper.getBody();
            LOGGER.log(Level.DEBUG,"Datos en: "+wrapperBody.datos());

            var prediccionRaw=climaInternalClient.getPrediccionRaw(wrapperBody.datos().substring(38));
            LOGGER.log(Level.DEBUG,"Resultado client RAW: "+prediccionRaw);

            ObjectMapper rawStringObjectMapper=new ObjectMapper();
            try {
                var prediccionJornadaTrim=prediccionRaw.substring(1,prediccionRaw.lastIndexOf("]")).trim();
                rawStringObjectMapper
                        .coercionConfigDefaults()
                        .setCoercion(CoercionInputShape.EmptyString, CoercionAction.TryConvert);
                var resultInternal=rawStringObjectMapper
                        .readValue(prediccionJornadaTrim, PrediccionJornadaInternalResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client parseada: "+resultInternal);

                var result=cs.convert(resultInternal,PrediccionJornadaResponseDto.class);
                LOGGER.log(Level.DEBUG,"Resultado client final mapeada: "+result);
                return result;

            } catch (JsonProcessingException e) {
                LOGGER.log(Level.ERROR,"Error procesando el mensaje interno: "+e.getMessage());
                return new PrediccionJornadaResponseDto("N/A", "N/A", "N/A", new PrediccionJornadaDto((Collections.emptyList())));
            }
        }
        LOGGER.log(Level.ERROR,"Error al intentar conectar con la API. Cod respuesta: "+wrapper.getStatusCode());
        return new PrediccionJornadaResponseDto("N/A", "N/A", "N/A", new PrediccionJornadaDto((Collections.emptyList())));
    }
}
