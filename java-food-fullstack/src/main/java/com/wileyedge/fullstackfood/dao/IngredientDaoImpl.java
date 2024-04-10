package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.dao.mappers.IngredientMapper;
import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
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
        final String sql = "INSERT INTO ingredient (ingredientName, caloriesPerGram, " +
                "proteinsPerGram, fatsPerGram, carbohydratesPerGram) VALUES (?, ?, ?, ?, ?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->  {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingredient.getIngredientName());
            ps.setBigDecimal(2, ingredient.getCaloriesPerGram());
            ps.setBigDecimal(3, ingredient.getProteinsPerGram());
            ps.setBigDecimal(4, ingredient.getFatsPerGram());
            ps.setBigDecimal(5, ingredient.getCarbohydratesPerGram());
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
        final String sql = "SELECT ingredientId, ingredientName, caloriesPerGram, " +
                "proteinsPerGram, fatsPerGram, carbohydratesPerGram FROM ingredient";
        return jdbcTemplate.query(sql, new IngredientMapper());
    }

    @Override
    public Ingredient findIngredientById(int id) {
        final String sql = "SELECT ingredientId, ingredientName, caloriesPerGram, " +
                "proteinsPerGram, fatsPerGram, carbohydratesPerGram " +
                "FROM ingredient " +
                "WHERE ingredientId = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new IngredientMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // If no record found, return null
        }

    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        final String sql = "UPDATE ingredient " +
                "SET ingredientName = ?, caloriesPerGram = ?, proteinsPerGram = ?, " +
                "fatsPerGram = ?, carbohydratesPerGram = ? " +
                "WHERE ingredientId = ?";
        jdbcTemplate.update(sql,
                ingredient.getIngredientName(),
                ingredient.getCaloriesPerGram(),
                ingredient.getProteinsPerGram(),
                ingredient.getFatsPerGram(),
                ingredient.getCarbohydratesPerGram(),
                ingredient.getIngredientId()
                );
    }

    @Override
    public void deleteIngredient(int id) {
    // delete ingredient from table in database
        deleteIngredientFromMeal(id);
        final String sql = "DELETE FROM ingredient WHERE ingredientId = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addIngredientToMeal(int ingredientId, int mealId) {
        final String sql = "INSERT INTO meal_ingredient (mealId, ingredientId) VALUES (?, ?)";
        jdbcTemplate.update(sql, mealId, ingredientId);
    }

    @Override
    public void deleteIngredientFromMeal(int ingredientId) {
    // delete ingredient from bridge
        final String sql = "DELETE FROM meal_ingredient WHERE ingredient_id = ?";
        jdbcTemplate.update(sql, ingredientId);
    }
}
