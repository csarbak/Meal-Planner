package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(rs.getInt("ingredientId"));
        ingredient.setIngredientName(rs.getString("ingredientName"));
        ingredient.setCaloriesPerGram(rs.getBigDecimal("caloriesPerGram"));
        ingredient.setProteinsPerGram(rs.getBigDecimal("proteinsPerGram"));
        ingredient.setFatsPerGram(rs.getBigDecimal("fatsPerGram"));
        ingredient.setCarbohydratesPerGram(rs.getBigDecimal("carbohydratesPerGram"));

        return ingredient;
        //YOUR CODE ENDS HERE
    }
}
