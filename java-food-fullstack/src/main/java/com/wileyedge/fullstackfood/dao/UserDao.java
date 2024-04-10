package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.User;

import java.util.List;

public interface UserDao {

    User createNewUser(User teacher);

    List<User> getAllUsers();

    User findUserById(int id);

    void updateUser(User teacher);

    void deleteUser(int id);
}