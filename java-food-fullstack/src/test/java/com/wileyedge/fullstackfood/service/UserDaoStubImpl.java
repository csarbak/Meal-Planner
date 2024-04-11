package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.UserDao;
import com.wileyedge.fullstackfood.model.User;

import java.util.List;

public class UserDaoStubImpl implements UserDao {

    public User onlyUser;

    public UserDaoStubImpl(){
        onlyUser = new User();
        onlyUser.setUserId(300);
        onlyUser.setUserFName("Joe");
        onlyUser.setUserLName("Mama");
    }

    @Override
    public User createNewUser(User user) {
        if (user.getUserFName().isBlank() || user.getUserLName().isBlank()) {
            user.setUserFName("First Name blank, user NOT added");
            user.setUserLName("Last Name blank, user NOT added");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        //Pass through. There's no code to test in this method
        return null;
    }

    @Override
    public User findUserById(int id) {
        if (onlyUser.getUserId() != id) {
            onlyUser.setUserFName("User Not Found");
            onlyUser.setUserLName("User Not Found");
        }
        return onlyUser;
    }

    @Override
    public void updateUser(User user) {
        onlyUser.setUserFName(user.getUserFName());
        onlyUser.setUserLName(user.getUserLName());
    }

    @Override
    public void deleteUser(int id) {
        //Pass through. There's no code to test in this method
    }


}
