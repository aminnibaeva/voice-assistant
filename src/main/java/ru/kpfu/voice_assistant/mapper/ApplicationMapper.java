package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.entity.Application;

@Mapper
public interface ApplicationMapper {
    @Mapping(target = "user.id", source = "userId")
    Application toEntity(DomainDto dto, Long userId);

    @Mapping(target = "user.id", source = "userId")
    Application toEntity(String domain, Long userId);

    DomainDto toDto(Application entity);
}
