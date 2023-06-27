package com.wadajo.clima.domain.dto.response.internal;

import java.util.List;

public record PrediccionDiariaViento(List<String> direccion,
                                     List<String> velocidad,
                                     String periodo) {
}
