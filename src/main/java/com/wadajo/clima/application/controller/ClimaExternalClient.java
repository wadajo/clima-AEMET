package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.aemet.response.PrediccionWrapperResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ClimaExternalClient {

    @GetExchange("/prediccion/especifica/municipio/horaria/{codMunicipio}")
    ResponseEntity<PrediccionWrapperResponseDto> getPrediccionHorariaWrapper(@PathVariable String codMunicipio);

    @GetExchange("/prediccion/especifica/municipio/diaria/{codMunicipio}")
    ResponseEntity<PrediccionWrapperResponseDto> getPrediccionDiariaWrapper(@PathVariable String codMunicipio);
}
