package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "copies")
public class BookCopy {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "STAUS")
    private CopyStatus status;
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    @OneToOne
    @JoinColumn(name = "LENT_ID")
    private BookLent lent;

    public BookCopy(CopyStatus status) {
        this.status = status;
    }

    public void setStatus(CopyStatus status) {
        this.status = status;
    }
}
