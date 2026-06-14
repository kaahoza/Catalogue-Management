package com.anele.catalogue_management.controller;

import com.anele.catalogue_management.entity.Book;
import com.anele.catalogue_management.entity.BookType;
import com.anele.catalogue_management.service.BookService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
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
    public void setup() {
        sampleBook = new Book(1L,"Test Book", "ISBN123", LocalDate.of(2026,6,7), 200.00, BookType.HARDCOVER);
    }

    @Test
    void testAllBooks_ReturnListOfBooks() throws Exception {
        List<Book> books = Arrays.asList(sampleBook);
        Mockito.when(service.findAll()).thenReturn(books);

        mockMvc.perform(get("/api/books/getAllBooks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Test Book"));
    }

    @Test
    void testAddBook_ReturnCreatedBook() throws Exception {
        Mockito.when(service.save(any(Book.class))).thenReturn(sampleBook);

        mockMvc.perform(post("/api/books/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Book"))
                .andExpect(jsonPath("$.isbNumber").value("ISBN123"));
    }


}
