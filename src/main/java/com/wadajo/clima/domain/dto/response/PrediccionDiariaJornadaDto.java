package com.wadajo.clima.domain.dto.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.diaria.PrediccionDiariaJornadaValuesDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.diaria.PrediccionDiariaJornadaVientoDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.PrediccionDiariaDescDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.PrediccionDiariaSDescDto;

import java.util.List;

public record PrediccionDiariaJornadaDto(List<PrediccionDiariaSDescDto> probPrecipitacion,
                                         List<PrediccionDiariaSDescDto> cotaNieveProv,
                                         List<PrediccionDiariaDescDto> estadoCielo,
                                         List<PrediccionDiariaJornadaVientoDto> viento,
                                         List<PrediccionDiariaSDescDto> rachaMax,
                                         PrediccionDiariaJornadaValuesDto temperatura,
                                         PrediccionDiariaJornadaValuesDto sensTermica,
                                         PrediccionDiariaJornadaValuesDto humedadRelativa,
                                         Integer uvMax,
                                         String fecha
                               ) {
}
