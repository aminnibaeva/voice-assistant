package ru.kpfu.voice_assistant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainDto {
    private String id;
    private String domain;
    private String url;
    private String language;
}
