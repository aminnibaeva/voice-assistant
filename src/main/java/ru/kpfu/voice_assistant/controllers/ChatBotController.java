package ru.kpfu.voice_assistant.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ChatBotController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PostMapping("/upload-audio")
    public ResponseEntity<String> handleAudioUpload(@RequestPart("audio") MultipartFile audioFile) {
        try {

            String filePath = "E:/Пользователи/Alina/Desktop/out.mp3";
            File destFile = new File(filePath);

            audioFile.transferTo(destFile);

            return new ResponseEntity<>("Audio uploaded and saved as MP3 successfully", HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Error processing audio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}