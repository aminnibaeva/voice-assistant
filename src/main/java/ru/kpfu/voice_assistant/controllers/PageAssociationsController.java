package ru.kpfu.voice_assistant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.PageDto;
import ru.kpfu.voice_assistant.service.PageService;

@RestController
public class PageAssociationsController {

    @Autowired
    private PageService pageService;

    @PostMapping("/save-pages/{applicationId}")
    public void savePageAssociations(@RequestBody PageDto[] associations,
        @PathVariable Long applicationId) {
        pageService.savePages(applicationId, associations);
    }

    @GetMapping("/get-pages/{applicationId}")
    public List<PageDto> getPages(@PathVariable Long applicationId) {
        return pageService.getPages(applicationId);
    }
}
