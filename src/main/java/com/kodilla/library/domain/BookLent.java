package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "lends")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookLent {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COPY_ID")
    private BookCopy copy;
    @OneToOne
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
