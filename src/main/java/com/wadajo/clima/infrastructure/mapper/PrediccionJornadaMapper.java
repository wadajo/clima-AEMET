package com.wadajo.clima.infrastructure.mapper;

import com.wadajo.clima.domain.dto.aemet.response.PrediccionJornadaInternalResponseDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionJornadaInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionJornadaValueInternal;
import com.wadajo.clima.domain.dto.response.PrediccionDiariaJornadaDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaDto;
import com.wadajo.clima.domain.dto.response.PrediccionJornadaResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring",nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PrediccionJornadaMapper extends Converter<PrediccionJornadaInternalResponseDto, PrediccionJornadaResponseDto> {

    @Mapping(target = "municipio", source = "nombre")
    @BeanMapping(ignoreByDefault = true)
    @Override
    PrediccionJornadaResponseDto convert(PrediccionJornadaInternalResponseDto prediccionJornadaInternalResponseDto);

    List<PrediccionJornadaDto> prediccionJornadaInternalToPrediccionJornadaDto(List<PrediccionJornadaInternal> prediccionJornadaInternals);

    PrediccionDiariaJornadaDto prediccionJornadaValueInternalToPrediccionDiariaJornadaDto(PrediccionJornadaValueInternal prediccionJornadaValueInternal);

}
