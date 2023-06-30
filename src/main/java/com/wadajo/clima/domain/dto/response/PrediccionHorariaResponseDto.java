package com.wadajo.clima.domain.dto.response;

public record PrediccionHorariaResponseDto(String elaborado,
                                           String municipio,
                                           String provincia,
                                           PrediccionDto prediccion) { }
