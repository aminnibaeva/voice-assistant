package ru.kpfu.voice_assistant.service;

import ru.kpfu.voice_assistant.dto.ChangePasswordDto;
import ru.kpfu.voice_assistant.dto.UserConfirmation;
import ru.kpfu.voice_assistant.dto.UserDto;

public interface UserService {
    boolean saveUser(UserDto userDto);

    void confirm(UserConfirmation request);

    boolean recoveryPassword(String email);

    String changePassword(String email, ChangePasswordDto changePasswordDto);
}
