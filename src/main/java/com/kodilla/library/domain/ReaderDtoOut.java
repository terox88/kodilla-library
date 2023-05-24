package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class ReaderDtoOut {
    private final int id;
    private final String name;
    private final String lastname;
    private final Date created;
    private final List<BookLent> lents;
}
