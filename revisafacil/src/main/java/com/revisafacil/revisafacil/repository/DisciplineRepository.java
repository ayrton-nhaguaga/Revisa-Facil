package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.Discipline;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends MongoRepository<Discipline, String> {

    Optional<Discipline> findById(ObjectId id);

    List<Discipline> findByUserId(ObjectId userId);

    List<Discipline> findByNameContainingIgnoreCase(String name);

    @Override
    List<Discipline> findAll();

    List<Discipline> findByDate(LocalDateTime date);
}
