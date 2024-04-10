package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest //This makes each test transactional, so changes to the db get rolled back after each test
public class UserDaoImplTests {
    private JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    @Autowired
    public void UserDaoImplTests(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        userDao = new UserDaoImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Create New User Test")
    public void createNewUserTest(){
        User user = new User();
        user.setUserFName("FirstName");
        user.setUserLName("LastName");
        userDao.createNewUser(user);
        List<User> users = userDao.getAllUsers();
        assertNotNull(users);
        assertEquals(11, users.size());

    }

    @Test
    @DisplayName("Get All Users Test")
    public void getAllUsersTest(){
        List<User> newList = userDao.getAllUsers();
        assertNotNull(newList);
        assertEquals(10, newList.size());
    }

    @Test
    @DisplayName("Find A User By ID: 6 Test")
    public void findUserByID6Test(){
        User user = userDao.findUserById(6);
        assertNotNull(user);
        assertEquals("Michael Jones", user.getUserFName() + " " + user.getUserLName());
    }

    @Test
    @DisplayName("Update User Info Test")
    public void updateUserInfoTest(){
        User user = new User();
        user.setUserId(3);
        user.setUserFName("Hazel");
        user.setUserLName("Nutt");
        userDao.updateUser(user);
        List<User> newList = userDao.getAllUsers();
        assertNotNull(newList);
        int i = 0;
        for(User currUser: newList) {
            if (currUser.getUserFName().contains("Hazel")) {
                i++;
            }
        }
        assertTrue(i != 0);

        int j = 0;
        for (User currentUser : newList) {
            if (currentUser.getUserLName().contains("Nutt")) {
                j++;
            }
        }
        assertTrue(j != 0);

    }

    @Test
    @DisplayName("Delete a User Test")
    public void deleteAUserTest(){
        userDao.deleteUser(1);
        List<User> newList = userDao.getAllUsers();
        assertNotNull(newList);
        assertEquals(9, newList.size());
    }

}
