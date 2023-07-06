package com.wadajo.clima.domain.dto.response;

import com.wadajo.clima.domain.dto.aemet.response.internal.horaria.PrediccionDiariaVientoDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.PrediccionDiariaDescDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.shared.PrediccionDiariaSDescDto;

import java.util.List;

public record PrediccionDiariaDto(List<PrediccionDiariaDescDto> estadoCielo,
                                  List<PrediccionDiariaSDescDto> precipitacion,
                                  List<PrediccionDiariaSDescDto> probPrecipitacion,
                                  List<PrediccionDiariaSDescDto> probTormenta,
                                  List<PrediccionDiariaSDescDto> nieve,
                                  List<PrediccionDiariaSDescDto> probNieve,
                                  List<PrediccionDiariaSDescDto> temperatura,
                                  List<PrediccionDiariaSDescDto> sensTermica,
                                  List<PrediccionDiariaSDescDto> humedadRelativa,
                                  List<PrediccionDiariaVientoDto> vientoAndRachaMax,
                                  String fecha,
                                  String salidaSol,
                                  String ocaso
                               ) {
}
