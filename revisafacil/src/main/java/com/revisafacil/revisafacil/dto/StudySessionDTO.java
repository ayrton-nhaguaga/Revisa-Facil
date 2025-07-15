package com.revisafacil.revisafacil.dto;

import com.revisafacil.revisafacil.model.Topic;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class StudySessionDTO {
    private ObjectId id;

    @NotBlank
    private ObjectId userId;

    @NotBlank
    private Topic topic;

    @NotBlank
    private LocalDateTime startTime;

    @NotBlank
    private LocalDateTime endTime;

    @NotBlank
    private int durationMinutes;
}
