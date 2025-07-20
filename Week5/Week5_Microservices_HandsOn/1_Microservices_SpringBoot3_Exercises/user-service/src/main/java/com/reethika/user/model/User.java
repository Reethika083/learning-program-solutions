package com.reethika.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;
    private String name;
    private String email;

    // Getters and Setters
}
