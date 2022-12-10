package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.request.AuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;


    @PostMapping("/author/create")
    public void create(@RequestBody AuthorRequest authorRequest) {
        Author author = Author.builder()
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .gender(authorRequest.getGender())
                .birthDate(authorRequest.getBirthDate())
                .build();

        List<Book> bookList = authorRequest.getBookList()
                .stream()
                .map(book -> new Book(book.getName(), book.getPublishedAt(), book.getPageCount()))
                .collect(Collectors.toList());
        author.setAllBooks(bookList);
        authorRepository.save(author);

    }
}
