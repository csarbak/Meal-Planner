package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setUserFName(rs.getString("userFName"));
        user.setUserLName(rs.getString("userLName"));

        return user;
    }

}
