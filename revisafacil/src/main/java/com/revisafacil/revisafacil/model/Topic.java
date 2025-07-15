package com.revisafacil.revisafacil.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "topics")
@Data
public class Topic {

    @Id
    private ObjectId id;

    private Discipline discipline;
    private String title;
    private String content;
    private List<String> resources;
    private Boolean completed;
    private LocalDateTime createdAt;
}
