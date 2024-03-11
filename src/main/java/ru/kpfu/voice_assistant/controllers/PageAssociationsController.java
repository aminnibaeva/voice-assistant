package ru.kpfu.voice_assistant.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.PageAssociationDto;

@RestController
public class PageAssociationsController {
    @PostMapping("/save-page-associations")
    public void savePageAssociations(@RequestBody PageAssociationDto[] associations) {
        System.out.println();
    }
}
