package com.wadajo.clima.domain.dto.aemet.response.internal;

import java.util.List;

public record PrediccionJornadaValueInternal(List<PrediccionDiariaSDescDto> probPrecipitacion,
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
