package ru.kpfu.voice_assistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatBotController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}
