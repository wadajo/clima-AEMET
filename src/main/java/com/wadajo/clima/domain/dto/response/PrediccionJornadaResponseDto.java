package com.wadajo.clima.domain.dto.response;

public record PrediccionJornadaResponseDto(String elaborado,
                                           String municipio,
                                           String provincia,
                                           PrediccionJornadaDto prediccion) { }
