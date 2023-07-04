package com.wadajo.clima.domain.dto.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionDiariaDescDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionDiariaJornadaValuesDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionDiariaJornadaVientoDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionDiariaSDescDto;

import java.util.List;

public record PrediccionDiariaJornadaDto(List<PrediccionDiariaSDescDto> probPrecipitacion,
                                         List<PrediccionDiariaSDescDto> cotaNieveProv,
                                         List<PrediccionDiariaDescDto> estadoCielo,
                                         List<PrediccionDiariaJornadaVientoDto> viento,
                                         List<PrediccionDiariaSDescDto> rachaMax,
                                         List<PrediccionDiariaJornadaValuesDto> temperatura,
                                         List<PrediccionDiariaJornadaValuesDto> sensTermica,
                                         List<PrediccionDiariaJornadaValuesDto> humedadRelativa,
                                         Integer uvMax,
                                         String fecha
                               ) {
}
