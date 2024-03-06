package ru.kpfu.voice_assistant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailOrUsername(String email, String username);

    Optional<User> findByUsernameAndEmail(String username, String email);

    boolean existsByEmailOrUsername(String email, String username);

    Optional<User> findByEmail(String email);
}
