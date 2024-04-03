package ru.kpfu.voice_assistant.service;

import java.util.List;

import ru.kpfu.voice_assistant.dto.UserQueryDto;

public interface UserQueryService {
    List<UserQueryDto> getUserQueries(Long userId);
}
