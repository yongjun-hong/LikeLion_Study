package com.example.manyproject.service;

import com.example.manyproject.dto.BookDto;
import com.example.manyproject.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}