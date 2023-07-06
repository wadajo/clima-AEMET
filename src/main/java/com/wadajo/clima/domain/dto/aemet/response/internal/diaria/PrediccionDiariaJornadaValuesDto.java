package com.wadajo.clima.domain.dto.aemet.response.internal.diaria;

import java.util.List;

public record PrediccionDiariaJornadaValuesDto(Integer maxima,
                                               Integer minima,
                                               List<PrediccionDiariaJornadaValueInternalDto> dato) {
}
