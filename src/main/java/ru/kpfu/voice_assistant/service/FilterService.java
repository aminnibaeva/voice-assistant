package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.FilterDto;

import java.util.List;

public interface FilterService {
    List<FilterDto> getFilters(Long applicationId);

    void saveFilters(FilterDto[] filters, Long applicationId);
}
