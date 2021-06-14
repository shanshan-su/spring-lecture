package com.codeup.springlecture.models;

import javax.persistence.*;

@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 50)
    private String species;

}
