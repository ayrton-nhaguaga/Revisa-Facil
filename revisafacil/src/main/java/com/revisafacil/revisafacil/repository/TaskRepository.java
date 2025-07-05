package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.enums.TaskStatus;
import com.revisafacil.revisafacil.model.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    Optional<Task> findById(ObjectId id);

    Optional<Task> findByUserId(ObjectId userId);

    @Override
    List<Task> findAll();

    List<Task> findByTitleContainigIgnoreCase(String title);

    List<Task> findByTopicId(ObjectId topicId);

    List<Task> findByDueDate(LocalDateTime dueDate);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByCreateDate(LocalDateTime createdAt);
}
