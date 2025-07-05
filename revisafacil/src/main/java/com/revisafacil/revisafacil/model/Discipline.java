package com.revisafacil.revisafacil.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("disciplines")
@Data
public class Discipline {

    @Id
    private ObjectId id;

    private ObjectId userId;
    private String name;
    private String description;
    private String color;
    private LocalDate createAt;
}
