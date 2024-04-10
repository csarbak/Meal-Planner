package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class IngredientDaoImpl implements IngredientDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public IngredientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Ingredient createNewIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredient (ingredientId, ingredientName) VALUES (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->  {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,  ingredient.getIngredientId());
            ps.setString(2, ingredient.getIngredientName());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            int ingredientId = keyHolder.getKey().intValue();
            ingredient.setIngredientId(ingredientId);
        } else {
            throw new RuntimeException("Failed to retrieve auto generated key for ingredient.");
        }
        return ingredient;

    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public Ingredient findIngredientById(int id) {
        return null;
    }

    @Override
    public void updateIngredient(Ingredient Ingredient) {

    }

    @Override
    public void deleteIngredient(int id) {

    }

    @Override
    public void addIngredientToMeal(int IngredientId, int mealId) {

    }

    @Override
    public void deleteIngredientFromMeal(int IngredientId, int mealId) {

    }
}
