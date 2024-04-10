package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
        return null;
    }

}
