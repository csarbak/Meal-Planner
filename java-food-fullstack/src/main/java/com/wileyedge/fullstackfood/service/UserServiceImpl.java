package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.UserDao;
import com.wileyedge.fullstackfood.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        try {
            // Attempt to retrieve a user by their ID
            return userDao.findUserById(id);
        } catch (DataAccessException e) {
            // Handle any DataAccessException by returning a "not found" user object
            User userNotFound = new User();
            userNotFound.setUserFName("User Not Found");
            userNotFound.setUserLName("User Not Found");
            return userNotFound;
        }
    }

    @Override
    public User addNewUser(User user) {
        if (user.getUserFName().isBlank()) {
            user.setUserFName("First Name blank, user NOT added");
        } else if (user.getUserLName().isBlank()) {
            user.setUserLName("Last Name blank, user NOT added");
        }
        // Otherwise, add the new user through the DAO
        return userDao.createNewUser(user);
    }

    @Override
    public User updateUserData(int id, User user) {
        if (id != user.getUserId()) {
            user.setUserFName("IDs do not match, user not updated");
            user.setUserLName("IDs do not match, user not updated");
            return user;
        }
        // Update the user if the IDs match
        userDao.updateUser(user);
        return userDao.findUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUser(id);
        System.out.println("User ID: " + id + " deleted");
    }
}
