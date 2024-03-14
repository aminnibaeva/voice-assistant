package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.UserConfirmation;
import ru.kpfu.voice_assistant.dto.UserDto;
import ru.kpfu.voice_assistant.entity.User;

public interface UserService {
    boolean saveUser(UserDto userDto);

    boolean confirm(UserConfirmation request);

    User findByEmailOrUsername(String email, String username);
}
