package com.wadajo.clima.domain.dto.response.internal;

import java.util.List;

public record PrediccionDiaria(List<PrediccionDiariaDesc> estadoCielo,
                               List<PrediccionDiariaSDesc> precipitacion,
                               List<PrediccionDiariaSDesc> probPrecipitacion,
                               List<PrediccionDiariaSDesc> probTormenta,
                               List<PrediccionDiariaSDesc> nieve,
                               List<PrediccionDiariaSDesc> probNieve,
                               List<PrediccionDiariaSDesc> temperatura,
                               List<PrediccionDiariaSDesc> sensTermica,
                               List<PrediccionDiariaSDesc> humedadRelativa,
                               List<PrediccionDiariaViento> vientoAndRachaMax,
                               String fecha,
                               String orto,
                               String ocaso
                               ) {
}
