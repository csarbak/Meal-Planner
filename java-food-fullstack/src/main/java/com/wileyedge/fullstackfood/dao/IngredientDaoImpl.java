package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientDaoImpl implements IngredientDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public IngredientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Ingredient createNewIngredient(Ingredient Ingredient) {
        return null;
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
    public void addIngredientToMeal(int IngredientId, int courseId) {

    }

    @Override
    public void deleteIngredientFromMeal(int IngredientId, int courseId) {

    }
}
