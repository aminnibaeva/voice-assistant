package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.LanguageCodes;

public interface LanguageCodesRepository extends JpaRepository<LanguageCodes, Long> {
}
