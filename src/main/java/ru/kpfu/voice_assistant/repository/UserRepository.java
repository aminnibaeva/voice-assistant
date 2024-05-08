package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndEmail(String username, String email);

    boolean existsByEmailOrUsername(String email, String username);

    Optional<User> findByEmail(String email);
}
