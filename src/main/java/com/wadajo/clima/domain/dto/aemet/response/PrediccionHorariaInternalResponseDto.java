package com.wadajo.clima.domain.dto.aemet.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.horaria.PrediccionInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.OrigenInternal;

public record PrediccionHorariaInternalResponseDto(OrigenInternal origen,
                                                   String elaborado,
                                                   String nombre,
                                                   String provincia,
                                                   PrediccionInternal prediccion,
                                                   String id,
                                                   String version) { }
