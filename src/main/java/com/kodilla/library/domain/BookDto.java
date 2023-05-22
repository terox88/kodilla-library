package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String author;
    private int publishYear;
    private List<BookCopy> copies;
}
