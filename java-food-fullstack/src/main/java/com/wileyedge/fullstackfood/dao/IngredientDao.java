package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    Ingredient createNewIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient findIngredientById(int id);

    void updateIngredient(Ingredient ingredient);

    void deleteIngredient(int id);

    void deleteIngredientFromMeal(int ingredientId);
}
