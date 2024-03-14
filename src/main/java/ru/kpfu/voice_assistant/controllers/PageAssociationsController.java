package ru.kpfu.voice_assistant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    @PostMapping("/save-pages/{domain}")
    public void savePageAssociations(@RequestBody PageDto[] associations, @PathVariable String domain) {
        User user = (User) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
        pageService.savePages(domain, associations, user.getUsername());
    }

    @GetMapping("/get-pages/{domain}")
    public List<PageDto> getPages(@PathVariable String domain) {
        User user = (User) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
        return pageService.getPages(user.getUsername(), domain);
    }
}
