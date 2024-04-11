package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.IngredientDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;

import java.math.BigDecimal;
import java.util.List;

public class IngredientDaoStubImpl implements IngredientDao {


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
    public void deleteIngredientFromMeal(int IngredientId) {

    }
}
