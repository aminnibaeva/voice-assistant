package ru.kpfu.voice_assistant.security.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.security.domain.model.Role;
import ru.kpfu.voice_assistant.security.domain.model.User;
import ru.kpfu.voice_assistant.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public User save(User user) {
        return repository.save(user);
    }


    /**
     * Создание пользователя
     *
     * @return создан ли в системе новый пользователь
     */
    public boolean create(User user) {
        Optional<User> userFromDb = repository.findByUsernameAndEmail(user.getUsername(), user.getEmail());
        if (userFromDb.isPresent()) {
            if (userFromDb.get().getState().equals(User.State.NOT_CONFIRMED)) {
                userFromDb.get().setConfirmCode(user.getConfirmCode());
                user = userFromDb.get();
            }
        } else {
            if (repository.existsByEmailOrUsername(user.getEmail(), user.getUsername())) {
                return false;
            }
        }
        save(user);
        return true;
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User getByUsername(String username) {
        return repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }


    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    @Deprecated
    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ADMIN);
        save(user);
    }

    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
