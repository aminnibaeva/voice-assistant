package ru.kpfu.voice_assistant.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.security.domain.dto.ConfirmRequest;
import ru.kpfu.voice_assistant.security.domain.dto.JwtAuthenticationResponse;
import ru.kpfu.voice_assistant.security.domain.dto.SignInRequest;
import ru.kpfu.voice_assistant.security.domain.dto.SignUpRequest;
import ru.kpfu.voice_assistant.security.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public ResponseEntity<Boolean> signUp(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok().body(authenticationService.signUp(request));
    }

    @Operation(summary = "Подтверждение почты пользователя")
    @PostMapping("/confirm")
    public ResponseEntity<Boolean> confirm(@RequestBody @Valid ConfirmRequest request) {
        return ResponseEntity.ok().body(authenticationService.confirm(request));
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}

