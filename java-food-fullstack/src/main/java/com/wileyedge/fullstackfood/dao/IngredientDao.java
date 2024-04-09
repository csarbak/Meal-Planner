package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    Ingredient createNewIngredient(Ingredient Ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient findIngredientById(int id);

    void updateIngredient(Ingredient Ingredient);

    void deleteIngredient(int id);

    void addIngredientToMeal(int IngredientId, int mealId);

    void deleteIngredientFromMeal(int IngredientId, int mealId);
}
