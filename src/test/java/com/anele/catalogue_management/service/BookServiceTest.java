package com.anele.catalogue_management.service;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book();

        book.setId(1L);
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
    }

    @Test
    void shouldReturnAllBooks() {

        // Arrange
        when(bookRepository.findAll())
                .thenReturn(List.of(book));

        // Act
        List<Book> result = bookService.getAllBooks();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());
        assertEquals("Robert C. Martin", result.get(0).getAuthor());

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnBookById() {

        // Arrange
        when(bookRepository.findById(1L))
                .thenReturn(Optional.of(book));

        // Act
        Book result = bookService.getBookById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Clean Code", result.getTitle());
        assertEquals("Robert C. Martin", result.getAuthor());

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnNullWhenBookDoesNotExist() {

        // Arrange
        when(bookRepository.findById(999L))
                .thenReturn(Optional.empty());

        // Act
        Book result = bookService.getBookById(999L);

        // Assert
        assertNull(result);

        verify(bookRepository, times(1)).findById(999L);
    }

    @Test
    void shouldSaveBook() {

        // Arrange
        when(bookRepository.save(book))
                .thenReturn(book);

        // Act
        Book result = bookService.saveBook(book);

        // Assert
        assertNotNull(result);
        assertEquals("Clean Code", result.getTitle());
        assertEquals("Robert C. Martin", result.getAuthor());

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void shouldUpdateBook() {

        // Arrange
        Book updatedBook = new Book();
        updatedBook.setTitle("Effective Java");
        updatedBook.setAuthor("Joshua Bloch");

        when(bookRepository.save(updatedBook))
                .thenReturn(updatedBook);

        // Act
        Book result = bookService.update(1L, updatedBook);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Effective Java", result.getTitle());
        assertEquals("Joshua Bloch", result.getAuthor());

        verify(bookRepository, times(1)).save(updatedBook);
    }

    @Test
    void shouldDeleteBook() {

        // Act
        bookService.deleteBook(1L);

        // Assert
        verify(bookRepository, times(1))
                .deleteById(1L);
    }
}