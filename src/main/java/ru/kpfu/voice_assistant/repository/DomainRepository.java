package ru.kpfu.voice_assistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.User;

public interface DomainRepository extends JpaRepository<Application, Long> {
    List<Application> getApplicationsByUser(User user);

    void deleteAllByDomainInAndUser(List<String> domain, User user);
}
