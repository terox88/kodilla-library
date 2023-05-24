package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class BookLentDtoIn {
    private int id;
    private int bookCopyId;
    private int readerId;


}
