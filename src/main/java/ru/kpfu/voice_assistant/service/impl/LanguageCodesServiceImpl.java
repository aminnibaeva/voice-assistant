package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.dto.LanguageCodesDto;
import ru.kpfu.voice_assistant.mapper.LanguageCodesMapper;
import ru.kpfu.voice_assistant.repository.LanguageCodesRepository;
import ru.kpfu.voice_assistant.service.LanguageCodesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageCodesServiceImpl implements LanguageCodesService {
    @Autowired
    private LanguageCodesRepository languageCodesRepository;
    @Autowired
    private LanguageCodesMapper languageCodesMapper;

    @Override
    public List<LanguageCodesDto> getLanguageCodes() {
        return languageCodesRepository.findAll().stream().map(languageCodesMapper::toDto).collect(Collectors.toList());
    }
}
