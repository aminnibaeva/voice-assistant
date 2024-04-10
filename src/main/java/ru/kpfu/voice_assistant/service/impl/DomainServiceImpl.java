package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.voice_assistant.dto.DomainDto;
import ru.kpfu.voice_assistant.dto.TokenDto;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.LanguageCodes;
import ru.kpfu.voice_assistant.entity.User;
import ru.kpfu.voice_assistant.mapper.ApplicationMapper;
import ru.kpfu.voice_assistant.repository.DomainRepository;
import ru.kpfu.voice_assistant.repository.LanguageCodesRepository;
import ru.kpfu.voice_assistant.repository.UserRepository;
import ru.kpfu.voice_assistant.service.DomainService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageCodesRepository languageCodesRepository;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Transactional
    @Override
    public void saveDomains(DomainDto[] domainDtos, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        List<Application> currentDomains = domainRepository.getApplicationsByUser(user);
        List<Application> domainToSave = new ArrayList<>();
        Arrays.asList(domainDtos).forEach(domain -> {
            String[] languageCountry = domain.getLanguage().split(", ");
            LanguageCodes languageCodes =
                    languageCodesRepository.findByLanguageAndCountry(languageCountry[0], languageCountry[1])
                            .orElseThrow(() -> new NoSuchElementException("Код языка не найден"));
            Optional<Application> application = findByDomain(currentDomains, domain.getDomain(),
                    languageCodes.getId());
            if (application.isEmpty()) {
                domainToSave.add(applicationMapper.toEntity(domain, user.getId(), languageCodes.getId()));
            } else if (application.get().getLanguageCode().getId() != languageCodes.getId()) {
                application.get().setLanguageCode(languageCodes);
                domainToSave.add(application.get());
                currentDomains.remove(application.get());
            } else {
                currentDomains.remove(application.get());
            }
        });
        domainRepository.deleteAll(currentDomains);
        domainRepository.saveAll(domainToSave);
    }

    public Optional<Application> findByDomain(List<Application> applications, String domain, Long languageCodeId) {
        return applications.stream()
                .filter(app -> app.getDomain().equals(domain))
                .findFirst();
    }

    @Transactional
    @Override
    public List<DomainDto> getDomains(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        return domainRepository.getApplicationsByUserOrderByApplicationId(user)
                .stream()
                .map(applicationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TokenDto> getTokens(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        return domainRepository.getApplicationsByUser(user)
                .stream()
                .map(applicationMapper::toTokens)
                .collect(Collectors.toList());
    }
}
