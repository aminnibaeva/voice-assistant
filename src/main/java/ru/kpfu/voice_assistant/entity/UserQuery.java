package ru.kpfu.voice_assistant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "query_name", nullable = false)
    private String queryName;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "url_application", nullable = false)
    private String urlApplication;

    @Column(name = "number_of_visits", nullable = false)
    private Long numberOfVisits;

    @ManyToOne()
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;
}