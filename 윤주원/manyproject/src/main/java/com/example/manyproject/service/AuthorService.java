package com.example.manyproject.service;

import com.example.manyproject.dto.AuthorDto;
import com.example.manyproject.entity.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}

