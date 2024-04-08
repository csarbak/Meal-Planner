package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.model.Meal;

import java.util.List;

public interface MealServiceInterface {
    List<Meal> getAllMeals();

    Meal getMealById(int id);

    Meal addNewMeal(Meal meal);

    Meal updateMealData(int id, Meal meal);

    void deleteMealById(int id);
}
