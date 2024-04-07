package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.LanguageCodes;

import java.util.Optional;

public interface LanguageCodesRepository extends JpaRepository<LanguageCodes, Long> {
    Optional<LanguageCodes> findByLanguageAndCountry(String language, String country);
}
