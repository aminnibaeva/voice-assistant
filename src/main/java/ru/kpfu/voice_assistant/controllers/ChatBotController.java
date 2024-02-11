package ru.kpfu.voice_assistant.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class ChatBotController {
    @Value("${python.voice.recognizer.url}")
    private String voiceRecognizerUrl;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PostMapping("/recognize-audio")
    public String recognizeAudio(@RequestPart("audio") MultipartFile file) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest requestRecognizeText = HttpRequest.newBuilder()
                .uri(URI.create(voiceRecognizerUrl))
                .POST(HttpRequest.BodyPublishers.ofByteArray(file.getBytes()))
                .build();
        HttpResponse<String> recognizedAudioResponse = httpClient.send(requestRecognizeText, HttpResponse.BodyHandlers.ofString());

        return recognizedAudioResponse.body();
    }
}