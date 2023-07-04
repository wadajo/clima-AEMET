package com.wadajo.clima.domain.dto.aemet.response;

public record PrediccionWrapperResponseDto(String descripcion,
                                           Integer estado,
                                           String datos,
                                           String metadatos) {}
