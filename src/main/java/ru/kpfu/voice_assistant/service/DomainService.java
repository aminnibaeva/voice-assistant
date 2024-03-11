package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.DomainDto;

public interface DomainService {
    void saveDomains(DomainDto[] domainDtos, String email);
}
