package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
@Getter
@AllArgsConstructor
public class ReaderDto {
    private int id;
    private String name;
    private String lastname;
    private Date created;
    private List<BookLent> lents;

    public ReaderDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
