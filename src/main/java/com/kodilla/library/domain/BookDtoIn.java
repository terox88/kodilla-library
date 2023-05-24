package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDtoIn {
    private int id;
    private String title;
    private String author;
    private int publishYear;

}
