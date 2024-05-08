package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.Application;
import ru.kpfu.voice_assistant.entity.User;

import java.util.List;

public interface DomainRepository extends JpaRepository<Application, Long> {
    List<Application> getApplicationsByUserOrderByApplicationId(User user);

    List<Application> getApplicationsByUser(User user);
}
