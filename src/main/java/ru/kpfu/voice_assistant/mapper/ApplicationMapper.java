package ru.kpfu.voice_assistant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.dto.TokenDto;
import ru.kpfu.voice_assistant.entity.Application;

@Mapper
public interface ApplicationMapper {
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "languageCode.id", source = "languageCode")
    @Mapping(target = "token", expression = "java(java.util.UUID.randomUUID().toString())")
    Application toEntity(DomainDto dto, Long userId, Long languageCode);

    @Mapping(target = "language",
        expression = "java(entity.getLanguageCode().getLanguage() + \", \" + entity" +
                     ".getLanguageCode().getCountry())")
    @Mapping(target = "id", source = "applicationId")
    DomainDto toDto(Application entity);

    TokenDto toTokens(Application entity);
}
