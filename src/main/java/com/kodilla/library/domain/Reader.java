package com.kodilla.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity(name = "readers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Reader {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "REGISTER")
    private Date created;
    @OneToMany(
            targetEntity = BookLent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<BookLent> lents;


    public Reader(String name, String lastname, Date created) {
        this.name = name;
        this.lastname = lastname;
        this.created = new Date();
    }
}
