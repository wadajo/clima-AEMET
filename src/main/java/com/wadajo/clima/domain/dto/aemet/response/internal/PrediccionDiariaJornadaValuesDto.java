package com.wadajo.clima.domain.dto.aemet.response.internal;

import java.util.List;

public record PrediccionDiariaJornadaValuesDto(Integer maxima,
                                               Integer minima,
                                               List<PrediccionDiariaJornadaValueInternalDto> dato) {
}
