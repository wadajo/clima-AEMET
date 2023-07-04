package com.wadajo.clima.domain.dto.aemet.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.OrigenInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionJornadaInternal;

public record PrediccionJornadaInternalResponseDto(OrigenInternal origen,
                                                   String elaborado,
                                                   String nombre,
                                                   String provincia,
                                                   PrediccionJornadaInternal prediccion,
                                                   String id,
                                                   String version) { }
