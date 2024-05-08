package ru.kpfu.voice_assistant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
    private Long filterId;

    private String filterName;

    private String filterType;

    private Long applicationId;
}
