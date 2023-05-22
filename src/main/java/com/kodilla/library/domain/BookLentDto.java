package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class BookLentDto {
    private int id;
    private int bookCopyId;
    private int readerId;
    private LocalDate lentBegin;
    private LocalDate lentEnd;

    public BookLentDto(int bookCopyId, int readerId) {
        this.bookCopyId = bookCopyId;
        this.readerId = readerId;
    }
}
