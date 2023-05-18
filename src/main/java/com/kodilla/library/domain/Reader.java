package com.kodilla.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
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

    public Reader(String name, String lastname, Date created) {
        this.name = name;
        this.lastname = lastname;
        this.created = new Date();
    }
}
