package com.anele.catalogue_management.controller;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Tag(name = "Book API", description = "Crud operation for managing book")
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @Operation(summary = "Get all books", description = "Retrieve a list of books in the catalogue.")
    @GetMapping("/getAllBooks")
    public List<Book> findAll() {
        return service.getAllBooks();
    }

    @Operation(summary = "Add a book", description = "Create and save a new book to the catalogue")
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @Operation(summary = "Get book by id", description = "Retrieve a book by its ID")
    @GetMapping("/getBook/{id}")
    public Book findBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @Operation(summary = "Update an existing book" , description = "Update the details of an existing book by ID")
    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return service.update(id, book);

    }

    @Operation(summary = "Delete a book", description = "Delete a book from the catalogue by ID")
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

}
