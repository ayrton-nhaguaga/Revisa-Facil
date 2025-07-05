package com.revisafacil.revisafacil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private ObjectId id;

    @NotBlank
    @Size(min = 0, max = 30)
    private String name;

    @NotBlank
    @Size(min = 0, max = 150)
    private String email;

    private LocalDateTime createAt;
}
