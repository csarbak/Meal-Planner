package com.wileyedge.fullstackfood.dao.mappers;

import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Tuple;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.Arrays;

public class MealIngredientMapper implements RowMapper<AbstractMap.SimpleEntry<Ingredient, BigDecimal>> {
    @Override
    public AbstractMap.SimpleEntry<Ingredient, BigDecimal> mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(rs.getInt("ingredientId"));
        ingredient.setIngredientName(rs.getString("ingredientName"));
        ingredient.setCaloriesPerGram(rs.getBigDecimal("caloriesPerGram"));
        ingredient.setProteinsPerGram(rs.getBigDecimal("proteinsPerGram"));
        ingredient.setFatsPerGram(rs.getBigDecimal("fatsPerGram"));
        ingredient.setCarbohydratesPerGram(rs.getBigDecimal("carbohydratesPerGram"));


        return new AbstractMap.SimpleEntry(ingredient, rs.getBigDecimal("quantityRatioOfIngredient"));





        //YOUR CODE ENDS HERE
    }
}
