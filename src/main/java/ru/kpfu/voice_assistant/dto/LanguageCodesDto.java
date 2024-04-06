package ru.kpfu.voice_assistant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCodesDto {
    private Long id;

    private String language;

    private String country;

    private String code;
}
