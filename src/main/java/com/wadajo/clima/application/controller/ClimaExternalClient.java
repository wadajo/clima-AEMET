package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaWrapperResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ClimaExternalClient {

    @GetExchange("/{codMunicipio}")
    PrediccionHorariaWrapperResponseDto getPrediccionHorariaWrapper(@PathVariable String codMunicipio);
}
