package com.example.manyproject.controller;

import com.example.manyproject.dto.BookDto;
import com.example.manyproject.entity.Author;
import com.example.manyproject.entity.Book;
import com.example.manyproject.service.AuthorServiceImpl;
import com.example.manyproject.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class AuthorBookController {


    private final BookServiceImpl bookService;

    private final AuthorServiceImpl authorService;

    public AuthorBookController(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long Id) {
        Book bookDto = bookService.getBookById(Id);
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.created(URI.create("/books/" + createdBook.getId())).body(createdBook);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(bookId, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookId}/authors")
    public ResponseEntity<List<Author>> getAuthorsForBook(@PathVariable Long bookId) {
        List<Author> authorDtos = (List<Author>) authorService.getAuthorById(bookId);
        return ResponseEntity.ok(authorDtos);
    }

    @PostMapping("/{bookId}/authors")
    public ResponseEntity<Void> addAuthorToBook(@PathVariable Long bookId, @RequestBody Book book) {
        bookService.updateBook(bookId, book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<Void> removeAuthorFromBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
