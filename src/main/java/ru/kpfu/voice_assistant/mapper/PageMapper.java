package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.voice_assistant.dto.PageDto;
import ru.kpfu.voice_assistant.entity.Page;

@Mapper
public interface PageMapper {
    PageDto toDto(Page entity);

    @Mapping(target = "application.applicationId", source = "applicationId")
    Page toEntity(PageDto page, Long applicationId);
}
