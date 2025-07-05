package com.revisafacil.revisafacil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class TopicDTO {

    private ObjectId id;

    @NotBlank
    private ObjectId disciplineId;

    @NotBlank
    @Size(min = 0, max = 50)
    private String title;

    @NotBlank
    private String content;

    private List<String> resources;

    @NotNull
    private Boolean completed;

    @NotBlank
    private LocalDateTime createdAt;
}
