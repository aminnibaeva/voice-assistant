package ru.kpfu.voice_assistant.dto;

public class RecognizedVoiceDto {
    private String text;

    public RecognizedVoiceDto() {
    }

    public RecognizedVoiceDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
