package com.example.securingweb.Model;


import javax.persistence.*;

@Entity

public class MyUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @Column(nullable = false, unique = true)
    String username;
    String password;

    public MyUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public MyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public MyUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
