package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import ru.kpfu.voice_assistant.dto.LanguageCodesDto;
import ru.kpfu.voice_assistant.entity.LanguageCodes;

@Mapper
public interface LanguageCodesMapper {
    LanguageCodesDto toDto(LanguageCodes entity);

    LanguageCodes toEntity(LanguageCodesDto dto);
}
