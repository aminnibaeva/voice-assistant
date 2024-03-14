package ru.kpfu.voice_assistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.Page;

public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> getPagesByApplication(Application application);
    void deleteAllByApplicationAndPageNameIn(Application application, List<String> pageNames);
}
