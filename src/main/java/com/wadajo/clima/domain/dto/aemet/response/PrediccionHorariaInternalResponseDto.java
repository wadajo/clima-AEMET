package com.wadajo.clima.domain.dto.aemet.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.OrigenInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionInternal;

public record PrediccionHorariaInternalResponseDto(OrigenInternal origen,
                                                   String elaborado,
                                                   String nombre,
                                                   String provincia,
                                                   PrediccionInternal prediccion,
                                                   String id,
                                                   String version) { }
