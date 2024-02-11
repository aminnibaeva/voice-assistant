package ru.kpfu.voice_assistant.mongo_repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.kpfu.voice_assistant.mongo_dto.AudioDocument;

public interface AudioRepository extends MongoRepository<AudioDocument, String> {
}
