package com.wadajo.clima.domain.dto.response;

import com.wadajo.clima.domain.dto.response.internal.Origen;
import com.wadajo.clima.domain.dto.response.internal.Prediccion;

public record PrediccionHorariaInternalResponseDto(Origen origen,
                                                   String elaborado,
                                                   String localidad,
                                                   String provincia,
                                                   Prediccion prediccion,
                                                   String codMunicipio,
                                                   String version) { }
