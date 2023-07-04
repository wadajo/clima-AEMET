package com.wadajo.clima.infrastructure.mapper;

import com.wadajo.clima.domain.dto.aemet.response.PrediccionHorariaInternalResponseDto;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionDiariaInternal;
import com.wadajo.clima.domain.dto.aemet.response.internal.PrediccionInternal;
import com.wadajo.clima.domain.dto.response.PrediccionDiariaDto;
import com.wadajo.clima.domain.dto.response.PrediccionDto;
import com.wadajo.clima.domain.dto.response.PrediccionHorariaResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PrediccionHorariaMapper extends Converter<PrediccionHorariaInternalResponseDto, PrediccionHorariaResponseDto> {

    @Mapping(target = "municipio", source = "nombre")
    @BeanMapping(ignoreByDefault = true)
    @Override
    PrediccionHorariaResponseDto convert(PrediccionHorariaInternalResponseDto prediccionHorariaInternalResponseDto);

    List<PrediccionDto> prediccionInternalToPrediccionDto(List<PrediccionInternal> prediccionInternals);

    @Mapping(target = "salidaSol",source = "orto")
    PrediccionDiariaDto prediccionDiariaInternalToPrediccionDiariaDto(PrediccionDiariaInternal prediccionDiariaInternal);


}
