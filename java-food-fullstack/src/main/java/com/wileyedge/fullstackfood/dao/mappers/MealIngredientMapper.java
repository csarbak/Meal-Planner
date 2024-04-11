package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;

public class MealIngredientMapper implements RowMapper<AbstractMap.SimpleEntry<Ingredient, BigDecimal>> {
    @Override
    public AbstractMap.SimpleEntry<Ingredient, BigDecimal> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(rs.getInt("ingredientId"));
        ingredient.setIngredientName(rs.getString("ingredientName"));
        ingredient.setCaloriesPerGram(rs.getBigDecimal("caloriesPerGram"));
        ingredient.setProteinsPerGram(rs.getBigDecimal("proteinsPerGram"));
        ingredient.setFatsPerGram(rs.getBigDecimal("fatsPerGram"));
        ingredient.setCarbohydratesPerGram(rs.getBigDecimal("carbohydratesPerGram"));


        return new AbstractMap.SimpleEntry(ingredient, rs.getBigDecimal("quantityRatioOfIngredient"));

    }
}
