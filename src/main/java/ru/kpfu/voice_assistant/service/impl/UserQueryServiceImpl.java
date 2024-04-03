package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.dto.UserQueryDto;
import ru.kpfu.voice_assistant.mapper.UserQueryMapper;
import ru.kpfu.voice_assistant.repository.UserQueryRepository;
import ru.kpfu.voice_assistant.service.UserQueryService;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    @Autowired
    private UserQueryRepository userQueryRepository;
    @Autowired
    private UserQueryMapper userQueryMapper;

    @Override
    public List<UserQueryDto> getUserQueries(Long userId) {
        return userQueryRepository.getUsersQueriesByUserIdOrderByNumberOfVisitsDesc(userId)
                .stream()
                .map(userQueryMapper::toDto)
                .toList();
    }
}
