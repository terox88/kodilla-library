package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class BookLentDtoOut {
    private int id;
    private int bookCopyId;
    private int readerId;
    private LocalDate lentBegin;
    private LocalDate lentEnd;


}
