package ru.kpfu.voice_assistant.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.voice_assistant.dto.PageAssociationDto;
import ru.kpfu.voice_assistant.dto.RecognizedVoiceDto;

@RestController
public class ChatBotController {
    @Value("${python.voice.recognizer.url}")
    private String voiceRecognizerUrl;

    @PostMapping("/recognize-audio")
    public ResponseEntity<RecognizedVoiceDto> recognizeAudio(
        @RequestPart("audio") MultipartFile file) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest requestRecognizeText = HttpRequest.newBuilder()
            .uri(URI.create(voiceRecognizerUrl))
            .POST(HttpRequest.BodyPublishers.ofByteArray(file.getBytes()))
            .build();
        HttpResponse<String> recognizedAudioResponse = httpClient.send(requestRecognizeText,
            HttpResponse.BodyHandlers.ofString()
        );

        if (recognizedAudioResponse.body().equals("")) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new RecognizedVoiceDto(recognizedAudioResponse.body()));
    }

    @PostMapping("/save-page-associations")
    public void savePageAssociations(@RequestBody PageAssociationDto[] rowData) {
        System.out.println();
    }
}