package com.example.relationstask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "publisher")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime created_date;
    private LocalDateTime updated_date;

    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private List<Book> bookList;

}

