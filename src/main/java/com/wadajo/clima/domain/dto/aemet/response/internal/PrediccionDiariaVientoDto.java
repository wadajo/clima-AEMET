package com.wadajo.clima.domain.dto.aemet.response.internal;

import java.util.List;

public record PrediccionDiariaVientoDto(List<String> direccion,
                                        List<String> velocidad,
                                        String value,
                                        String periodo) {
}
