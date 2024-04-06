package ru.kpfu.voice_assistant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private String domain;
    
    private String token;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "application")
    private List<Page> pages;

    @ManyToOne()
    @JoinColumn(name = "language_id")
    private LanguageCodes languageCode;
}
