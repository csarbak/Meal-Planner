package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Meal;

import java.util.List;

public interface MealDao {

    Meal createNewMeal(Meal meal);

    List<Meal> getAllMeals();

    Meal findMealById(int id);

    void updateMeal(Meal meal);

    void deleteMeal(int id);

    void deleteAllIngredientsFromMeal(int MealId);
}
