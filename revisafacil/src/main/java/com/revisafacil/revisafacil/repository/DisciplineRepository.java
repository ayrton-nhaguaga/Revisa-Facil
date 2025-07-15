package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.Discipline;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplineRepository extends MongoRepository<Discipline, String> {

    Optional<Discipline> findById(ObjectId id);

    List<Discipline> findByUserId(ObjectId userId);

    List<Discipline> findByNameContainingIgnoreCase(String name);

    @Override
    List<Discipline> findAll();

    List<Discipline> findByCreateAt(LocalDate createAt);
}
