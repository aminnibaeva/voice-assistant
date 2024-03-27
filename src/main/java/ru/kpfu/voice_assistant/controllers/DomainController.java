package ru.kpfu.voice_assistant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.dto.TokenDto;
import ru.kpfu.voice_assistant.service.DomainService;

import java.util.List;

@RestController
public class DomainController {
    @Autowired
    private DomainService domainService;

    @PostMapping("/save-domain")
    public void saveDomains(@RequestBody DomainDto[] domains) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        domainService.saveDomains(domains, user.getUsername());
    }

    @GetMapping("/get-domains")
    public List<DomainDto> getDomains() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return domainService.getDomains(user.getUsername());
    }

    @GetMapping("/get-tokens")
    public List<TokenDto> getTokens() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return domainService.getTokens(user.getUsername());
    }
}
