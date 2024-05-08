package ru.kpfu.voice_assistant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.FilterDto;
import ru.kpfu.voice_assistant.service.FilterService;

import java.util.List;

@RestController
public class FilterController {
    @Autowired
    private FilterService filterService;

    @GetMapping("/get-filters/{applicationId}")
    public List<FilterDto> getFilters(@PathVariable Long applicationId) {
        return filterService.getFilters(applicationId);
    }

    @PostMapping("/save-filters/{applicationId}")
    public void saveFilters(@RequestBody FilterDto[] filters, @PathVariable Long applicationId) {
        filterService.saveFilters(filters, applicationId);
    }
}
