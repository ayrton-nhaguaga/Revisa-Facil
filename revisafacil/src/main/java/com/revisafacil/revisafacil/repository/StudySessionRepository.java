package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.StudySession;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudySessionRepository extends MongoRepository<StudySession, String> {

    Optional<StudySession> findById(ObjectId id);

    @Override
    List<StudySession> findAll();

    List<StudySession> findByUserId(ObjectId userId);

    List<StudySession> findByTopicId(ObjectId topicId);

    List<StudySession> findByDuration(int duration);
}
