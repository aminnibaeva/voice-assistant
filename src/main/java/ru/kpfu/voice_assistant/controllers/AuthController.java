package ru.kpfu.voice_assistant.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.voice_assistant.dto.ChangePasswordDto;
import ru.kpfu.voice_assistant.dto.RecoveryPasswordDto;
import ru.kpfu.voice_assistant.dto.UserConfirmation;
import ru.kpfu.voice_assistant.dto.UserDto;
import ru.kpfu.voice_assistant.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @GetMapping("recovery")
    public String showRecoveryPasswordForm(Model model) {
        model.addAttribute("recoveryPassword", new RecoveryPasswordDto());
        return "recovery";
    }

    @GetMapping("profile")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("changePassword", new ChangePasswordDto());
        return "profile";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }
        model.addAttribute("registrationSuccessful", true);

        if (!userService.saveUser(userDto)) {
            result.rejectValue("email", null,
                    "There is already an account registered with that email or username"
            );
        }
        model.addAttribute("userConfirmation", new UserConfirmation());
        model.addAttribute("confirmEmail", userDto.getEmail());

        return "register";
    }

    @PostMapping("/confirm")
    public String confirm(@Valid @ModelAttribute("userConfirmation") UserConfirmation user) {
        userService.confirm(user);
        return "login";
    }

    @PostMapping("/recovery")
    public String passwordRecovery(@Valid @ModelAttribute("recoveryPassword") RecoveryPasswordDto recoveryPassword,
                                   Model model) {
        if (!userService.recoveryPassword(recoveryPassword.getEmail())) {
            model.addAttribute("userNotExists", true);
            return "recovery";
        } else {
            return "login";
        }
    }

    @PostMapping("/change-password")
    public String changePassword(@Valid @ModelAttribute("changePassword") ChangePasswordDto changePasswordDto,
                                 BindingResult result) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String message = userService.changePassword(user.getUsername(), changePasswordDto);
        if (message != null) {
            result.rejectValue("oldPassword", null, message);
        }
        return "profile";
    }
}
