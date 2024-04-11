package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User addNewUser(User user);

    User updateUserData(int id, User user);

    void deleteUserById(int id);
}
