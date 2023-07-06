package com.wadajo.clima.domain.dto.aemet.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.diaria.PrediccionJornadaInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.OrigenInternal;

public record PrediccionJornadaInternalResponseDto(OrigenInternal origen,
                                                   String elaborado,
                                                   String nombre,
                                                   String provincia,
                                                   PrediccionJornadaInternal prediccion,
                                                   String id,
                                                   String version) { }
