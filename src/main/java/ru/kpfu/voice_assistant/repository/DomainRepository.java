package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.Application;

public interface DomainRepository extends JpaRepository<Application, Long> {
}
