package com.example.securingweb;

public class RegisterInfo {
    String username;
    String password;

    public RegisterInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterInfo() {
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
        return "RegisterInfo{" +
                "login='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
