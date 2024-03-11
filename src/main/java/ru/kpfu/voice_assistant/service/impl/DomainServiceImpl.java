package ru.kpfu.voice_assistant.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.User;
import ru.kpfu.voice_assistant.mapper.ApplicationMapper;
import ru.kpfu.voice_assistant.repository.DomainRepository;
import ru.kpfu.voice_assistant.repository.UserRepository;
import ru.kpfu.voice_assistant.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public void saveDomains(DomainDto[] domainDtos, String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<Application> applications = Arrays.stream(domainDtos)
            .map(domainDto -> applicationMapper.toEntity(domainDto, user.getId()))
            .toList();
        domainRepository.saveAll(applications);
    }
}
