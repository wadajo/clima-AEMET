package com.wadajo.clima.application.controller;

import com.wadajo.clima.domain.dto.response.PrediccionHorariaWrapperResponseDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class ClimaGraphqlController {

    @QueryMapping
    Mono<PrediccionHorariaWrapperResponseDto> prediccionHorariaWrapper (@Argument String codMunicipio){
        return Mono.empty();
    }

}
