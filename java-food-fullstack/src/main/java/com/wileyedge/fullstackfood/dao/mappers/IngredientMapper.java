package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
        return null;
    }
}
