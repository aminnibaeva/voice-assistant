package ru.kpfu.voice_assistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.UserQuery;

public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {
    List<UserQuery> getUsersQueriesByUserIdIs(Long user_id);
}
