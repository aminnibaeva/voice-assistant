package ru.kpfu.voice_assistant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryDto {
    private String applicationId;
    private String userQueryId;
    private String queryName;
    private String url;
    private String urlApplication;
}
