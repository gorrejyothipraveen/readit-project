package com.tw.readit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getSameResponse(String data) {
        System.out.println("small modification...");
        return data;
    }

}
