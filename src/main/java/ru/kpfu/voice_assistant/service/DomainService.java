package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.dto.TokenDto;

import java.util.List;

public interface DomainService {
    void saveDomains(DomainDto[] domainDtos, String email);

    List<DomainDto> getDomains(String email);

    List<TokenDto> getTokens(String email);
}
