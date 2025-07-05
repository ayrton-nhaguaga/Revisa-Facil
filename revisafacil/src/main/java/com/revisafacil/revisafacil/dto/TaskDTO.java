package com.revisafacil.revisafacil.dto;

import com.revisafacil.revisafacil.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private ObjectId id;

    @NotBlank
    private ObjectId userId;

    @NotBlank
    @Size(min = 0, max = 50)
    private String title;

    @NotBlank
    @Size(min = 0, max = 500)
    private String description;

    @NotBlank
    private ObjectId topicId;

    @NotBlank
    private LocalDateTime dueDate;

    @NotBlank
    private TaskStatus status;

    @NotBlank
    private LocalDateTime createdAt;
}
