package com.revisafacil.revisafacil.repository;

import com.revisafacil.revisafacil.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

   Optional<User> findById(ObjectId id);

    @Override
    List<User> findAll();

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByEmailContainingIgnoreCase(String email);

    List<User> findByCreateAt(LocalDateTime date);
}
