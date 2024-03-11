package ru.kpfu.voice_assistant.entity;

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
@Table(name = "association")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long associationId;

    private String association;

    @ManyToOne()
    @JoinColumn(name = "page_id")
    private Page page;
}
