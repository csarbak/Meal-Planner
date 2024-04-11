package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.UserDao;
import com.wileyedge.fullstackfood.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTests {

    private UserServiceImpl userService;

    public UserServiceTests(){
        UserDao userDao = new UserDaoStubImpl();
        userService = new UserServiceImpl(userDao);
    }

    @Test
    @DisplayName("Find User Service Test")
    public void findUserServiceTest(){
        User returnUser = userService.getUserById(300);
        assertNotNull(returnUser);
        assertEquals("Joe", returnUser.getUserFName());
    }

    @Test
    @DisplayName("User Not Found Service Test")
    public void userNotFoundServiceTest(){
        User notFound = userService.getUserById(150);
        assertNotNull(notFound);
        assertEquals("User Not Found", notFound.getUserFName());
    }

    @Test
    @DisplayName("Update User Service Test")
    public void updateUserServiceTest(){
        User user = new User();
        user.setUserId(300);
        user.setUserFName("Updated User First Name");
        user.setUserLName("Updated User Last Name");

        User updatedUser = userService.updateUserData(300, user);
        assertNotNull(updatedUser);
        assertEquals(300, user.getUserId());
        assertEquals("Updated User First Name", updatedUser.getUserFName());
        assertEquals("Updated User Last Name", updatedUser.getUserLName());
    }

    @Test
    @DisplayName("User Not Updated Service Test")
    public void userNotUpdatedServiceTest(){
        User user = new User();
        user.setUserId(300);
        user.setUserFName("Updated First Name");
        user.setUserLName("Updated Last Name");

        User updatedUser = userService.updateUserData(150, user);
        assertEquals("IDs do not match, user not updated", user.getUserFName());
        assertEquals("IDs do not match, user not updated", user.getUserLName());
    }

    @Test
    @DisplayName("Add User Service Test")
    public void addUserServiceTest(){
        User user = new User();
        user.setUserFName("New User First Name");
        user.setUserLName("New User Last Name");
        User newUser = userService.addNewUser(user);
        assertNotNull(newUser);
        assertEquals("New User First Name", newUser.getUserFName());
        assertEquals("New User Last Name", newUser.getUserLName());
    }

    @Test
    @DisplayName("User Not Added Service Test")
    public void userNotAddedServiceTest(){
        User user = new User();
        user.setUserFName("");
        user.setUserLName("");
        User newUser = userService.addNewUser(user);
        assertEquals("First Name blank, user NOT added", user.getUserFName());
        assertEquals("Last Name blank, user NOT added", user.getUserLName());
    }
}
