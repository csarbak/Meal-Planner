package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.IngredientDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    IngredientDao IngredientDao;

    public IngredientServiceImpl(IngredientDao IngredientDao) {
        this.IngredientDao = IngredientDao;
    }


    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public Ingredient getIngredientById(int id) {
        return null;
    }

    @Override
    public Ingredient addNewIngredient(Ingredient Ingredient) {
        return null;
    }

    @Override
    public Ingredient updateIngredientData(int id, Ingredient Ingredient) {
        return null;
    }

    @Override
    public void deleteIngredientById(int id) {

    }
}
