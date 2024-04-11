package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.IngredientDao;
import com.wileyedge.fullstackfood.model.Ingredient;

import java.util.List;

public class IngredientDaoStubImpl implements IngredientDao {


    public Ingredient onlyIngredient;

    public IngredientDaoStubImpl() {
        onlyIngredient = new Ingredient();
        onlyIngredient.setIngredientId(100);
        onlyIngredient.setIngredientName("40 Foot Tall Test Carrot");
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public Ingredient findIngredientById(int id) {
        if (onlyIngredient.getIngredientId() != id) {
            onlyIngredient.setIngredientName("Ingredient Not Found");
        }
        return onlyIngredient;
    }

    @Override
    public Ingredient createNewIngredient(Ingredient ingredient) {
        if(ingredient.getIngredientName().isBlank()) {
            ingredient.setIngredientName("Name blank, ingredient NOT added");
        }
        return ingredient;
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        onlyIngredient.setIngredientName(ingredient.getIngredientName());
    }

    @Override
    public void deleteIngredient(int id) {
        //Pass through. There's no code to test in this method

    }

    @Override
    public void deleteIngredientFromMeal(int ingredientId) {
        //Pass through. There's no code to test in this method

    }
}
