package ru.kpfu.voice_assistant.service;

import java.util.List;

import ru.kpfu.voice_assistant.dto.PageDto;

public interface PageService {
    List<PageDto> getPages(String email, String domain);

    void savePages(String domain, PageDto[] pageDtos, String email);
}
