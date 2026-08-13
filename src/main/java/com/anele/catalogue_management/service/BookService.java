package com.anele.catalogue_management.service;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    private BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book update(Long id, Book book) {
        book.setId(id);
        return repository.save(book);
    }
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
