package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.voice_assistant.dto.PageDto;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.Page;
import ru.kpfu.voice_assistant.mapper.PageMapper;
import ru.kpfu.voice_assistant.repository.DomainRepository;
import ru.kpfu.voice_assistant.repository.PageRepository;
import ru.kpfu.voice_assistant.service.PageService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private PageMapper pageMapper;

    @Transactional
    @Override
    public List<PageDto> getPages(Long applicationId) {
        Application application = domainRepository.findById(applicationId)
            .orElseThrow(() -> new NoSuchElementException("Приложение с таким айди не найдено"));
        return pageRepository.getPagesByApplication(application)
            .stream()
            .map(pageMapper::toDto)
            .toList();
    }

    @Transactional
    @Override
    public void savePages(Long applicationId, PageDto[] pages) {
        Application application = domainRepository.findById(applicationId)
            .orElseThrow(() -> new NoSuchElementException("Приложение с таким айди не найдено"));


        List<PageDto> pagesForSave = new ArrayList<>();
        List<String> pageNames = pageRepository.getPagesByApplication(application)
            .stream()
            .map(Page::getPageName)
            .collect(Collectors.toList());
        Arrays.stream(pages).forEach(page -> {
            if (!pageNames.contains(page.getPageName())) {
                pagesForSave.add(page);
                pageNames.remove(page.getPageName());
            } else {
                pageNames.remove(page.getPageName());
            }
        });
        pageRepository.deleteAllByApplicationAndPageNameIn(application, pageNames);
        pagesForSave.forEach(page -> pageRepository.save(pageMapper.toEntity(page, application.getApplicationId())));
    }
}
