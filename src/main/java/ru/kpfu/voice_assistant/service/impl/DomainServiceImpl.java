package ru.kpfu.voice_assistant.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public void saveDomains(DomainDto[] domainDtos, String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<String> currentDomains = domainRepository.getApplicationsByUser(user)
            .stream()
            .map(Application::getDomain)
            .collect(
                Collectors.toList());
        List<String> domainsFromUser = Arrays.stream(domainDtos)
            .map(DomainDto::getDomain).toList();
        List<String> domainToSave = new ArrayList<>();
        domainsFromUser.forEach(domain -> {
            if (!currentDomains.contains(domain)) {
                domainToSave.add(domain);
                currentDomains.remove(domain);
            }
            else {
                currentDomains.remove(domain);
            }
        });

        domainRepository.deleteAllByDomainInAndUser(currentDomains, user);
        domainToSave.forEach(
            domain -> domainRepository.save(applicationMapper.toEntity(domain, user.getId())));
    }

    @Transactional
    @Override
    public List<DomainDto> getDomains(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return domainRepository.getApplicationsByUser(user)
            .stream()
            .map(applicationMapper::toDto)
            .collect(Collectors.toList());
    }
}
