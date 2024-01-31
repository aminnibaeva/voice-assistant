package ru.kpfu.voice_assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class VoiceAssistantApplication {
    public static void main(String[] args) {
        SpringApplication.run(VoiceAssistantApplication.class, args);
    }
}
