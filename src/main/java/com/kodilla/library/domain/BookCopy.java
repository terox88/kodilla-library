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

    @Column(name = "STATUS")
    private CopyStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LENT_ID")
    private BookLent lent;

    public BookCopy(CopyStatus status, Book book) {
        this.status = status;
        this.book = book;
    }

    public void setStatus(CopyStatus status) {
        this.status = status;
    }

    public void setLent(BookLent lent) {
        this.lent = lent;
    }
}
