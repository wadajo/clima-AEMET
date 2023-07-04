package com.wadajo.clima.domain.dto.aemet.response.internal;

public record PrediccionDiariaJornadaVientoDto(String direccion,
                                               Integer velocidad,
                                               String value,
                                               String periodo) {
}
