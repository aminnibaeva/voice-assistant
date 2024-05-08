package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.voice_assistant.dto.FilterDto;
import ru.kpfu.voice_assistant.entity.Filter;

@Mapper
public interface FilterMapper {
    FilterDto toDto(Filter entity);

    @Mapping(target = "application.applicationId", source = "applicationId")
    Filter toEntity(FilterDto filter, Long applicationId);
}
