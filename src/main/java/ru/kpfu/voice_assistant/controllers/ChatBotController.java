package ru.kpfu.voice_assistant.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class ChatBotController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PostMapping("/upload-audio")
    public ResponseEntity<String> handleAudioUpload(@RequestPart("audio") MultipartFile audioFile) {
        try {
            main(audioFile.getInputStream());
            return new ResponseEntity<>("Audio uploaded and saved as MP3 successfully", HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Error processing audio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void main(InputStream inputStream) {
        String outputFilePath = "E:/Пользователи/Alina/Desktop/output.wav";
        String[] ffmpegCommand = {"ffmpeg", "-i", "pipe:0", "-acodec", "pcm_s16le", outputFilePath};
        try {
            Process process = new ProcessBuilder(ffmpegCommand).start();
            OutputStream outputStream = process.getOutputStream();
            copyStream(inputStream, outputStream);
            outputStream.close();
            process.waitFor();
            if (process.exitValue() == 0) {
                System.out.println("Conversion successful!");
            } else {
                System.out.println("Conversion failed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the input stream if it's not null
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }
}