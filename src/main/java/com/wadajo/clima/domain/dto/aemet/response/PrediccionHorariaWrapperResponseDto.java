package com.wadajo.clima.domain.dto.aemet.response;

public record PrediccionHorariaWrapperResponseDto(String descripcion,
                                                  Integer estado,
                                                  String datos,
                                                  String metadatos) {}
