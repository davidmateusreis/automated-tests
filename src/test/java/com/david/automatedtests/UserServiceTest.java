package com.david.automatedtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void createUserSuccess() {
        // Arrange
        User user = new User("David", "123456");
        // Act
        List<User> users = userService.create(user);
        // Assert
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test
    public void createUserFailure() {

        User user = new User("David", "123456");

        userService.create(user);

        assertThrows(RuntimeException.class, () -> userService.create(user));
    }
}
