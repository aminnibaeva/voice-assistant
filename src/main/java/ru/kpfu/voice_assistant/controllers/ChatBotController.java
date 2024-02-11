package ru.kpfu.voice_assistant.controllers;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.voice_assistant.mongo_dto.AudioDocument;
import ru.kpfu.voice_assistant.mongo_repo.AudioRepository;

import java.io.IOException;

@Controller
public class ChatBotController {
    @Autowired
    private AudioRepository audioRepository;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PostMapping("/upload-audio")
    public String handleAudioUpload(@RequestPart("audio") MultipartFile file) throws IOException {
        AudioDocument audioDocument = AudioDocument.builder().audio(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
                .extension(".mka").build();
        audioDocument = audioRepository.insert(audioDocument);
        return audioDocument.getId();
    }
}