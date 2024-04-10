package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.dao.mappers.UserMapper;
import com.wileyedge.fullstackfood.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createNewUser(User user) {
        final String INSERT_USER = "INSERT INTO user(userFName, userLName) "
            + "VALUES(?,?)";
        jdbcTemplate.update(INSERT_USER,
            user.getUserFName(),
            user.getUserLName());
        int newId = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        user.setUserId(newId);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        return jdbcTemplate.query(SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public User findUserById(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE userId = ?";
            return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new UserMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        final String UPDATE_USER = "UPDATE user SET userFName = ?, userLName = ? "
            + "WHERE userId = ?";
        jdbcTemplate.update(UPDATE_USER,
            user.getUserFName(),
            user.getUserLName(),
            user.getUserId());
    }

    @Override
    public void deleteUser(int id) {

        final String DELETE_MEAL_INGREDIENT_BY_USER = "DELETE FROM meal_ingredient " +
            "WHERE meal_id IN (SELECT mealId FROM meal WHERE user_id = ?)";
        jdbcTemplate.update(DELETE_MEAL_INGREDIENT_BY_USER, id);

        final String DELETE_MEAL_BY_USER = "DELETE FROM meal WHERE user_id = ?";
        jdbcTemplate.update(DELETE_MEAL_BY_USER, id);

        final String DELETE_USER = "DELETE FROM user WHERE userId = ?";
        jdbcTemplate.update(DELETE_USER, id);
    }
}
