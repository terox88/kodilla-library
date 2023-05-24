package com.kodilla.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
public class ReaderDtoIn {
    private final int id;
    private final String name;
    private final String lastname;

}
