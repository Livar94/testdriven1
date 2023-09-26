import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Test
    public void testLoginWithValidCredentials() {
        // Mocka en databas
        Database mockDatabase = mock(Database.class);
        when(mockDatabase.getUserByUsername("testuser")).thenReturn(new User("testuser", "password123"));

        AuthenticationService authService = new AuthenticationService(mockDatabase);
        assertTrue(authService.login("testuser", "password123"));
    }

    @Test
    public void testLoginWithInvalidUsername() {
        // Mocka en databas
        Database mockDatabase = mock(Database.class);
        when(mockDatabase.getUserByUsername("nonexistentuser")).thenReturn(null);

        AuthenticationService authService = new AuthenticationService(mockDatabase);
        assertThrows(UserNotFoundException.class, () -> authService.login("nonexistentuser", "password123"));
    }

    @Test
    public void testLoginWithInvalidPassword() {
        // Mocka en databas
        Database mockDatabase = mock(Database.class);
        when(mockDatabase.getUserByUsername("testuser")).thenReturn(new User("testuser", "password123"));

        AuthenticationService authService = new AuthenticationService(mockDatabase);
        assertThrows(InvalidPasswordException.class, () -> authService.login("testuser", "wrongpassword"));
    }
}