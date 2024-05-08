package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.Filter;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    List<Filter> getFiltersByApplication(Application application);
}
