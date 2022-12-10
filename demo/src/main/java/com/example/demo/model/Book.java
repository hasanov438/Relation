package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate publishedAt;
    private int pageCount;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id" )
    private Author author;

    public Book(String name, LocalDate publishedAt, int pageCount) {
        this.name = name;
        this.publishedAt = publishedAt;
        this.pageCount = pageCount;
    }
}
