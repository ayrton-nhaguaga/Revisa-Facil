package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.StudySession;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudySessionRepository extends MongoRepository<StudySession, String> {

    Optional<StudySession> findById(ObjectId id);

    @Override
    List<StudySession> findAll();


    List<StudySession> findByTopicTitleContainingIgnoreCase(String title);

    List<StudySession> findByDurationMinutes(int durationMinutes);
}
