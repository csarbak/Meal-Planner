package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(int id);

    Ingredient addNewIngredient(Ingredient ingredient);

    Ingredient updateIngredientData(int id, Ingredient ingredient);

    void deleteIngredientById(int id);


}
