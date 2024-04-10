package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.dto.UserQueryDto;
import ru.kpfu.voice_assistant.entity.User;
import ru.kpfu.voice_assistant.mapper.UserQueryMapper;
import ru.kpfu.voice_assistant.repository.UserQueryRepository;
import ru.kpfu.voice_assistant.repository.UserRepository;
import ru.kpfu.voice_assistant.service.UserQueryService;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    @Autowired
    private UserQueryRepository userQueryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserQueryMapper userQueryMapper;

    @Override
    public List<UserQueryDto> getUserQueries(Long userId) {
        return userQueryRepository.getUsersQueriesByUserIdOrderByNumberOfVisitsDesc(userId)
            .stream()
            .map(userQueryMapper::toDto)
            .toList();
    }

    @Override
    public List<UserQueryDto> getUserQueries(String email, Long applicationId) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));

        return userQueryRepository.getUsersQueriesByUserIdAndApplicationApplicationIdOrderByNumberOfVisitsDesc(
                user.getId(), applicationId)
            .stream()
            .map(userQueryMapper::toDto)
            .toList();
    }
}
