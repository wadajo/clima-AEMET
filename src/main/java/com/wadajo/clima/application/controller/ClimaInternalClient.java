package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaInternalResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ClimaInternalClient {

    @GetExchange("/{location}")
    PrediccionHorariaInternalResponseDto getPrediccionHoraria(@PathVariable String location);
}
