package com.smbustillo.trivia.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

}
