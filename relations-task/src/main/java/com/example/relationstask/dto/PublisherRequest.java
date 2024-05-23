package com.example.relationstask.dto;

import com.example.relationstask.entity.Book;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PublisherRequest {
    private int id;
    @NotEmpty(message = "name should not be empty")
    @NotNull(message = "name should not be null")
    private String name;
    private String address;
    private List<Integer> bookList;
}
