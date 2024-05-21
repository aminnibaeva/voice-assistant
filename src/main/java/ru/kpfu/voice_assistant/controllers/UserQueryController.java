package ru.kpfu.voice_assistant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.UserQueryDto;
import ru.kpfu.voice_assistant.service.UserQueryService;

import java.util.List;

@RestController
public class UserQueryController {
    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/history")
    public List<UserQueryDto> getHistory(@RequestParam("user_id") Long userId) {
        return userQueryService.getUserQueries(userId);
    }

    @GetMapping("/test-history")
    public List<UserQueryDto> getTestHistory(@RequestParam("applicationId") Long applicationId) {
        User user = (User) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();

        return userQueryService.getUserQueries(user.getUsername(), applicationId);
    }
}
