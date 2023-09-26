package com.example.testdriven1;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testSetAndGetUsername() {
        User user = new User();
        user.setUsername("testuser");
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testSetAndGetPassword() {
        User user = new User();
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testEqualsMethod() {
        User user1 = new User("testuser", "password123");
        User user2 = new User("testuser", "password123");
        User user3 = new User("anotheruser", "password456");

        assertTrue(user1.equals(user2));
        assertFalse(user1.equals(user3));
    }
}
