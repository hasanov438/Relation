package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate birthDate;
    @Column(name = "first_name")
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String lastName;
    @OneToMany(mappedBy = "id")
    private List<Book> bookList;

    public void setAllBooks(List<Book> bookList) {
        bookList.forEach(b -> b.setAuthor(this));
        this.bookList = bookList;
    }
}
