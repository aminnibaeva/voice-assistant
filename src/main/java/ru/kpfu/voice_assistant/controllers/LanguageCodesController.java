package ru.kpfu.voice_assistant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.LanguageCodesDto;
import ru.kpfu.voice_assistant.service.LanguageCodesService;

import java.util.List;

@RestController
public class LanguageCodesController {
    @Autowired
    private LanguageCodesService languageCodesService;

    @GetMapping("/get-language-codes")
    public List<LanguageCodesDto> getLanguageCodes() {
        return languageCodesService.getLanguageCodes();
    }
}
