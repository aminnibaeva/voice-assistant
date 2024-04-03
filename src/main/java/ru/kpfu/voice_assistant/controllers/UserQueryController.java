package ru.kpfu.voice_assistant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.UserQueryDto;
import ru.kpfu.voice_assistant.service.UserQueryService;

@RestController
public class UserQueryController {
    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/history")
    public List<UserQueryDto> getHistory(@RequestParam("user_id") Long userId) {
        return userQueryService.getUserQueries(userId);
    }
}
