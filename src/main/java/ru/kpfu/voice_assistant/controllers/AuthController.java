package ru.kpfu.voice_assistant.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
}
