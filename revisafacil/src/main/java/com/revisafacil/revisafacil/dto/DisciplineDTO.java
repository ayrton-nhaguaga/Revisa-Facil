package com.revisafacil.revisafacil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Data
public class DisciplineDTO {
    private ObjectId id;

    @NotBlank
    private ObjectId userId;

    @NotBlank
    @Size(min = 0, max = 30)
    private String name;

    @NotBlank
    @Size(min = 0, max = 500)
    private String description;

    private String color;

    private LocalDate createAt;
}
