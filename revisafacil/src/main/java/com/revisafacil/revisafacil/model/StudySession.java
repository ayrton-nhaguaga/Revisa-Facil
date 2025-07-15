package com.revisafacil.revisafacil.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "studysessions")
@Data
public class StudySession {

    @Id
    private ObjectId id;

    private ObjectId userId;
    private Topic topic;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int durationMinutes;
}
