package com.example.testdriven1;

public class AuthenticationService {
    private Database database;

    public AuthenticationService(Database database) {
        this.database = database;
    }

    public boolean login(String username, String password) {
        User user = database.getUserByUsername(username);

        if (user == null) {
            throw new UserNotFoundException("Användaren finns inte.");
        }

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException("Ogiltigt lösenord.");
        }

        return true;
    }
}

