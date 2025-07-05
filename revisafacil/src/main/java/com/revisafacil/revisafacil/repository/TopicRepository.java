package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.Topic;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String> {

    Optional<Topic> findById (ObjectId id);

    List<Topic> findByDisciplineId(ObjectId disciplineId);

    List<Topic> findByTitleContaningIgnoreCase(String title);

    List<Topic> findByContentIgnoreCase(String content);

    List<Topic> findByCopleted(Boolean completed);

    @Override
    List<Topic> findAll();
}
