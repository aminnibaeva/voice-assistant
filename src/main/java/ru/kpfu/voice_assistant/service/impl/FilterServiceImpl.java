package ru.kpfu.voice_assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.dto.FilterDto;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.mapper.FilterMapper;
import ru.kpfu.voice_assistant.repository.DomainRepository;
import ru.kpfu.voice_assistant.repository.FilterRepository;
import ru.kpfu.voice_assistant.service.FilterService;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FilterServiceImpl implements FilterService {
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private FilterRepository filterRepository;
    @Autowired
    private FilterMapper filterMapper;

    @Override
    public List<FilterDto> getFilters(Long applicationId) {
        Application application = domainRepository.findById(applicationId)
            .orElseThrow(() -> new NoSuchElementException("Приложение с таким айди не найдено"));
        return filterRepository.getFiltersByApplication(application)
            .stream()
            .map(filterMapper::toDto)
            .toList();
    }

    @Override
    public void saveFilters(FilterDto[] filters, Long applicationId) {
        filterRepository.saveAll(
            Arrays.stream(filters)
                .map(filter -> {
                    filter.setFilterType(filter.getFilterType().toUpperCase());
                    return filterMapper.toEntity(filter, applicationId);
                })
                .toList());
    }
}
