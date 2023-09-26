package com.example.testdriven1;

public class User {
    private String username;
    private String password;

    // Konstruktor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter-metoder
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Equals-metod för att jämföra användarobjekt
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }
}

