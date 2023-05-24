package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity(name = "lents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookLent {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;
    @OneToOne
    @JoinColumn(name = "COPY_ID")
    private BookCopy copy;
    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;
    private LocalDate lentBegin;
    private LocalDate lentEnd;

    public BookLent(BookCopy copy, Reader reader) {
        this.copy = copy;
        this.reader = reader;
        this.lentBegin = LocalDate.now();
        this.lentEnd = lentBegin.plusMonths(1);
    }
}
