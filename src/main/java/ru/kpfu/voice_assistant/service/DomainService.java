package ru.kpfu.voice_assistant.service;

import java.util.List;

import ru.kpfu.voice_assistant.dto.DomainDto;

public interface DomainService {
    void saveDomains(DomainDto[] domainDtos, String email);

    List<DomainDto> getDomains(String email);
}
