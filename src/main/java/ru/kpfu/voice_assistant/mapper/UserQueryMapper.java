package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import ru.kpfu.voice_assistant.dto.UserQueryDto;
import ru.kpfu.voice_assistant.entity.UserQuery;

@Mapper
public interface UserQueryMapper {
    UserQueryDto toDto(UserQuery entity);
}
