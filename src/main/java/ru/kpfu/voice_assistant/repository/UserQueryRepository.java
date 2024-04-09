package ru.kpfu.voice_assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.voice_assistant.entity.UserQuery;

import java.util.List;

public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {
    List<UserQuery> getUsersQueriesByUserIdOrderByNumberOfVisitsDesc(Long userId);
    List<UserQuery> getUsersQueriesByUserIdAndApplicationApplicationIdOrderByNumberOfVisitsDesc(Long userId,
        Long applicationId);
}
