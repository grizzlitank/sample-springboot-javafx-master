package ru.ilyas.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "contact1")
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String date;


    public Contact() {
    }

    public Contact(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
