package ru.kpfu.voice_assistant.security.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.security.domain.dto.ConfirmRequest;
import ru.kpfu.voice_assistant.security.domain.dto.JwtAuthenticationResponse;
import ru.kpfu.voice_assistant.security.domain.dto.SignInRequest;
import ru.kpfu.voice_assistant.security.domain.dto.SignUpRequest;
import ru.kpfu.voice_assistant.security.domain.model.User;
import ru.kpfu.voice_assistant.util.EmailUtil;

import static ru.kpfu.voice_assistant.config.ApplicationConstants.SUBJECT_FOR_VERIFY_ACCOUNT_MAIL;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailUtil emailUtil;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return создан ли новый пользователь
     */
    public boolean signUp(SignUpRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .state(User.State.NOT_CONFIRMED)
            .confirmCode(UUID.randomUUID().toString())
            .build();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("confirmCode", user.getConfirmCode());

        if (userService.create(user)) {
            emailUtil.sendVerifyMail(user.getEmail(), SUBJECT_FOR_VERIFY_ACCOUNT_MAIL, userData);
            return true;
        }
        return false;
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.getUsername(), request.getPassword()));

        UserDetails user = userService
            .userDetailsService()
            .loadUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public boolean confirm(ConfirmRequest request) {
        User user = userService.getByEmail(request.getEmail())
            .orElseThrow(
                () -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        if (user.getState().equals(User.State.NOT_CONFIRMED) && user.getConfirmCode()
            .equals(request.getConfirmCode())) {
            user.setState(User.State.CONFIRMED);
            userService.save(user);
            return true;
        }
        return false;
    }
}
