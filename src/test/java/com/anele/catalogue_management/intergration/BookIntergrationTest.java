package com.anele.catalogue_management.integration;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.entity.BookType;
import com.anele.catalogue_management.repository.BookRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class BookIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16");

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldSaveAndRetrieveBook() {

        // Arrange
        Book book = new Book(
                null,
                "Clean Code",
                "Robert C. Martin",
                "ISBN-TEST-001",
                LocalDate.of(2026, 6, 7),
                200.00,
                BookType.HARDCOVER
        );

        // Act
        Book savedBook = bookRepository.save(book);

        Optional<Book> foundBook =
                bookRepository.findById(savedBook.getId());

        // Assert
        assertTrue(foundBook.isPresent());

        assertEquals(
                "Clean Code",
                foundBook.get().getTitle()
        );

        assertEquals(
                "Robert C. Martin",
                foundBook.get().getAuthor()
        );

        assertEquals(
                "ISBN-TEST-001",
                foundBook.get().getIsbNumber()
        );
    }
}