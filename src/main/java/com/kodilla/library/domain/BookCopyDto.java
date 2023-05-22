package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
@Getter
@AllArgsConstructor
public class BookCopyDto {
    private int id;
    private CopyStatus status;
    private int bookId;
    private int lentId;
}
