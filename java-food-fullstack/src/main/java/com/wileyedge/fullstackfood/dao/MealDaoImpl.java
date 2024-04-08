package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MealDaoImpl implements MealDao {

    private final JdbcTemplate jdbcTemplate;

    public MealDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Meal createNewMeal(Meal meal) {
        return null;
    }

    @Override
    public List<Meal> getAllMeals() {
        return null;
    }

    @Override
    public Meal findMealById(int id) {
        return null;
    }

    @Override
    public void updateMeal(Meal meal) {

    }

    @Override
    public void deleteMeal(int id) {

    }

    @Override
    public void deleteAllIngredientsFromMeal(int MealId) {

    }
}
