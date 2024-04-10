package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;

import java.math.BigDecimal;
import java.util.List;

public class MealDaoStubImpl implements MealDao {

    public Meal onlyMeal;



    @Override
    public Meal addNewMeal(Meal meal) {
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

//    @Override
//    public void deleteAllIngredientsFromMeal(int mealId) {
//
//    }

//    @Override
//    public List<Ingredient> getIngredientsFromMeal(int mealId) {
//        return null;
//    }

    @Override
    public BigDecimal calculateTotalCalories(int mealId) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalProteins(int mealId) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalFats(int mealId) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalCarbohydrates(int mealId) {
        return null;
    }
}
