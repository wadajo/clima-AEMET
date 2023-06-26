package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaInternalResponseDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ClimaClient {

    @GetExchange("/{searchCode}")
    PrediccionHorariaInternalResponseDto getPrediccionHoraria(@RequestParam String searchCode);
}
