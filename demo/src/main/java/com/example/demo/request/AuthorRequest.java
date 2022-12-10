package com.example.demo.request;

import com.example.demo.model.Book;
import com.example.demo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorRequest {
    private LocalDate birthDate;

    private String firstName;

    private Gender gender;
    private String lastName;

    private List<Book> bookList;
}
