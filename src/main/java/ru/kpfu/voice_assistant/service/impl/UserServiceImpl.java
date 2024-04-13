package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.voice_assistant.dto.ChangePasswordDto;
import ru.kpfu.voice_assistant.dto.UserConfirmation;
import ru.kpfu.voice_assistant.dto.UserDto;
import ru.kpfu.voice_assistant.entity.User;
import ru.kpfu.voice_assistant.repository.UserRepository;
import ru.kpfu.voice_assistant.service.UserService;
import ru.kpfu.voice_assistant.util.EmailUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static ru.kpfu.voice_assistant.config.ApplicationConstants.SUBJECT_FOR_RECOVERY_PASSWORD_MAIL;
import static ru.kpfu.voice_assistant.config.ApplicationConstants.SUBJECT_FOR_VERIFY_ACCOUNT_MAIL;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailUtil emailUtil;

    @Transactional
    @Override
    public boolean saveUser(UserDto userDto) {
        User user = User.builder()
            .username(userDto.getUsername())
            .email(userDto.getEmail())
            .password(passwordEncoder.encode(userDto.getPassword()))
            .role(User.Role.USER)
            .state(User.State.NOT_CONFIRMED)
            .confirmCode(UUID.randomUUID().toString())
            .build();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("confirmCode", user.getConfirmCode());

        Optional<User> userFromDb = userRepository.findByUsernameAndEmail(user.getUsername(),
            user.getEmail()
        );
        if (userFromDb.isPresent()) {
            if (userFromDb.get().getState().equals(User.State.NOT_CONFIRMED)) {
                userFromDb.get().setConfirmCode(user.getConfirmCode());
                user = userFromDb.get();
            }
        }
        else {
            if (userRepository.existsByEmailOrUsername(user.getEmail(), user.getUsername())) {
                return false;
            }
        }
        emailUtil.sendVerifyMail(user.getEmail(), SUBJECT_FOR_VERIFY_ACCOUNT_MAIL, userData);
        userRepository.save(user);
        return true;
    }

    @Transactional
    @Override
    public void confirm(UserConfirmation request) {
        User user = userRepository.findByEmail(request.getConfirmEmail())
            .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        if (user.getState().equals(User.State.NOT_CONFIRMED) && user.getConfirmCode()
            .equals(request.getConfirmCode())) {
            user.setState(User.State.CONFIRMED);
            userRepository.save(user);
        }
    }

    @Override
    public boolean recoveryPassword(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return false;
        }
        String newPassword = UUID.randomUUID().toString();
        user.get().setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user.get());

        Map<String, String> userData = new HashMap<>();
        userData.put("newPassword", newPassword);

        emailUtil.sendRecoveryPasswordMail(email, SUBJECT_FOR_RECOVERY_PASSWORD_MAIL, userData);

        return true;
    }

    @Override
    public String changePassword(String email, ChangePasswordDto changePasswordDto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));

        if (!changePasswordDto.getNewPassword().equals(changePasswordDto.getConfirmNewPassword())) {
            return "Пароли не совпадают.";
        }
        if (!passwordEncoder.matches(changePasswordDto.getOldPassword(), user.getPassword())) {
            return "Старый пароль не совпадает.";
        }
        user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
        userRepository.save(user);
        return null;
    }
}
