package com.anele.catalogue_management.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String title;
    private String author;
    private String isbNumber;
    private LocalDate publishDate;
    private Double price;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public Book(Long id, String title,String author, String isbNumber, LocalDate now, Double price, BookType bookType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbNumber = isbNumber;
        this.publishDate= now;
        this.price = price;
        this.bookType = bookType;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbNumber() {
        return isbNumber;
    }

    public void setIsbNumber(String isbNumber) {
        this.isbNumber = isbNumber;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getPrice() {
        return price.toString();
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
