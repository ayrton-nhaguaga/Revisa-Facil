package com.revisafacil.revisafacil.model;

import com.revisafacil.revisafacil.enums.TaskStatus;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
@Data
public class Task {

    @Id
    private ObjectId id;

    private ObjectId userId;
    private String title;
    private String description;
    private ObjectId topicId;
    private LocalDateTime dueDate;
    private TaskStatus status;
    private LocalDateTime createdAt;
}
