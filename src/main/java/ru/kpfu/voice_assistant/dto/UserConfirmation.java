package ru.kpfu.voice_assistant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alina Minnibaeva
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserConfirmation {
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String confirmEmail;
    @NotEmpty(message = "Confirmation code can not be empty")
    private String confirmCode;
}
