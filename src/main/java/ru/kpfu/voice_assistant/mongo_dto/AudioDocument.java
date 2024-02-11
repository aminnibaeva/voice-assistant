package ru.kpfu.voice_assistant.mongo_dto;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "audios")
public class AudioDocument {
    @Id
    private String id;
    private String extension;
    private Binary audio;
}
