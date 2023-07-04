package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaResponseDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaResponseDto;
import com.wadajo.clima.domain.service.PrediccionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ClimaGraphqlController {

    private final PrediccionService service;

    public ClimaGraphqlController(PrediccionService service) {
        this.service = service;
    }

    @QueryMapping
    PrediccionHorariaResponseDto prediccionHoraria (@Argument String codMunicipio) {
        return service.getPrediccionHorariaResponseDto(codMunicipio);
    }

    @QueryMapping
    PrediccionJornadaResponseDto prediccionDiaria (@Argument String codMunicipio) {
        return service.getPrediccionJornadaResponseDto(codMunicipio);
    }
}
