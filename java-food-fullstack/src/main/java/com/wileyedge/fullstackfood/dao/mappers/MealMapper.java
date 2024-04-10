package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.Meal;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealMapper implements RowMapper<Meal> {
    @Override
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        Meal meal = new Meal();
        meal.setMealId(rs.getInt("mealId"));
        meal.setMealName(rs.getString("mealName"));
        meal.setUserId(rs.getInt("user_id"));
        meal.setMealDesc(rs.getString("mealDesc"));

        return meal;
        //YOUR CODE ENDS HERE
    }
}
