package ru.kpfu.voice_assistant.service;

import java.util.List;

import ru.kpfu.voice_assistant.dto.PageDto;

public interface PageService {
    List<PageDto> getPages(Long applicationId);

    void savePages(Long applicationId, PageDto[] pageDtos);
}
