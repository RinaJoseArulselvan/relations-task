package com.example.relationstask.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class BookRequest {
    private int id;
    @NotEmpty(message = "name should not be empty")
    @NotNull(message = "name should not be null")
    private String title;
    private String description;
    @NotEmpty(message = "category should not be empty")
    @NotNull(message = "category should not be null")
    private String category;
    private int publisher_id;
}
