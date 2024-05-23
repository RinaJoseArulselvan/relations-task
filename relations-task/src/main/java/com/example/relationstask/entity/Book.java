package com.example.relationstask.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Table(name = "book")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private String category;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
