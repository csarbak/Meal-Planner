package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.model.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> getAllUsers();

    User getUserById(int id);

    User addNewUser(User teacher);

    User updateUserData(int id, User teacher);

    void deleteUserById(int id);
}
