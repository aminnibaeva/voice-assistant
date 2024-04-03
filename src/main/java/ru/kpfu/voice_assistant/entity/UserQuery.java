package ru.kpfu.voice_assistant.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_query")
public class UserQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_query_id", nullable = false)
    private Long userQueryId;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "query", nullable = false)
    private String query;

    @Column(name = "number_of_visits", nullable = false)
    private Long numberOfVisits;
}
