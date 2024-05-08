package ru.kpfu.voice_assistant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "filter")
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filterId;

    private String filterName;

    @Enumerated(EnumType.STRING)
    private FilterType filterType;

    @ManyToOne()
    @JoinColumn(name = "application_id")
    private Application application;
}
