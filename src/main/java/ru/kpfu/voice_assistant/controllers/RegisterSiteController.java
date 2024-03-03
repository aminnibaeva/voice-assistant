package ru.kpfu.voice_assistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterSiteController {
    @GetMapping("/register-site")
    public String homePage() {
        return "home";
    }
}
