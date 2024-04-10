package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;

import java.math.BigDecimal;
import java.util.List;

public interface MealDao {

    Meal addNewMeal(Meal meal);

    List<Meal> getAllMeals();

    Meal findMealById(int id);

    void updateMeal(Meal meal);

    void deleteMeal(int id);

    void deleteAllIngredientsFromMeal(int mealId);

    List<Ingredient> getIngredientsFromMeal(int mealId);

    BigDecimal calculateTotalCalories(int mealId);

    BigDecimal calculateTotalProteins(int mealId);

    BigDecimal calculateTotalFats(int mealId);

    BigDecimal calculateTotalCarbohydrates(int mealId);
}
