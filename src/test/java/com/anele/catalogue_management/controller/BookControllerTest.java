package com.anele.catalogue_management.controller;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.entity.BookType;
import com.anele.catalogue_management.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Book sampleBook;

    @BeforeEach
    void setup() {

        sampleBook = new Book(
                1L,
                "Clean Code",
                "Robert C. Martin",
                "ISBN123",
                LocalDate.of(2026, 6, 7),
                200.00,
                BookType.HARDCOVER
        );
    }

    @Test
    void shouldReturnAllBooks() throws Exception {

        // Arrange
        List<Book> books = Arrays.asList(sampleBook);

        Mockito.when(service.getAllBooks())
                .thenReturn(books);

        // Act & Assert
        mockMvc.perform(get("/api/books/getAllBooks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("Clean Code"))
                .andExpect(jsonPath("$[0].author").value("Robert C. Martin"));
    }

    @Test
    void shouldAddBook() throws Exception {

        // Arrange
        Mockito.when(service.saveBook(any(Book.class)))
                .thenReturn(sampleBook);

        // Act & Assert
        mockMvc.perform(post("/api/books/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andExpect(jsonPath("$.author").value("Robert C. Martin"))
                .andExpect(jsonPath("$.isbNumber").value("ISBN123"));
    }

    @Test
    void shouldGetBookById() throws Exception {

        // Arrange
        Mockito.when(service.getBookById(1L))
                .thenReturn(sampleBook);

        // Act & Assert
        mockMvc.perform(get("/api/books/getBook/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andExpect(jsonPath("$.author").value("Robert C. Martin"));
    }

    @Test
    void shouldUpdateBook() throws Exception {

        // Arrange
        Book updatedBook = new Book(
                1L,
                "Effective Java",
                "Joshua Bloch",
                "ISBN456",
                LocalDate.of(2026, 6, 8),
                250.00,
                BookType.HARDCOVER
        );

        Mockito.when(service.update(eq(1L), any(Book.class)))
                .thenReturn(updatedBook);

        // Act & Assert
        mockMvc.perform(put("/api/books/updateBook/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }

    @Test
    void shouldDeleteBook() throws Exception {

        // Arrange
        Mockito.doNothing()
                .when(service)
                .deleteBook(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/books/deleteBook/1"))
                .andExpect(status().isOk());

        Mockito.verify(service, Mockito.times(1))
                .deleteBook(1L);
    }
}