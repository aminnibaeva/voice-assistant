package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.entity.Application;

@Mapper
public interface ApplicationMapper {
    @Mapping(target = "user.id", source = "userId")
    Application toEntity(DomainDto dto, Long userId);

    DomainDto toDto(Application entity);
}
