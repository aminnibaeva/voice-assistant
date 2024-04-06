package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.LanguageCodesDto;

import java.util.List;

public interface LanguageCodesService {
    List<LanguageCodesDto> getLanguageCodes();
}
