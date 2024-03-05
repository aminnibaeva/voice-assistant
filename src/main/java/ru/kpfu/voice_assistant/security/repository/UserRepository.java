package ru.kpfu.voice_assistant.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.voice_assistant.security.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndEmail(String username, String email);
    boolean existsByEmailOrUsername(String email, String username);
    Optional<User> findByEmail(String email);
}