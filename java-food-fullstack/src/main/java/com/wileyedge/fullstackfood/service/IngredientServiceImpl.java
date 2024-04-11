package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.IngredientDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientDao ingredientDao;

    public IngredientServiceImpl(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }


    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientDao.getAllIngredients();
    }

    @Override
    public Ingredient getIngredientById(int id) {
        try {
            return ingredientDao.findIngredientById(id);
        } catch (DataAccessException e) {
            Ingredient ingredientNotFound = new Ingredient();
            ingredientNotFound.setIngredientName("Ingredient Not Found");
            return ingredientNotFound;
        }
    }

    @Override
    public Ingredient addNewIngredient(Ingredient ingredient) {
        if (ingredient.getIngredientName().isBlank()) {
            ingredient.setIngredientName("Name blank, ingredient NOT added");
        }
        if (ingredient.getCaloriesPerGram() == null) {
            ingredient.setCaloriesPerGram(new BigDecimal(-1));
        }
        if (ingredient.getCarbohydratesPerGram() == null) {
            ingredient.setCarbohydratesPerGram(new BigDecimal(-1));
        }
        if (ingredient.getFatsPerGram() == null) {
            ingredient.setFatsPerGram(new BigDecimal(-1));
        }
        if (ingredient.getProteinsPerGram() == null) {
            ingredient.setProteinsPerGram(new BigDecimal(-1));
        }
        return ingredientDao.createNewIngredient(ingredient);
    }

    @Override
    public Ingredient updateIngredientData(int id, Ingredient ingredient) {
        if (id != ingredient.getIngredientId()) {
            ingredient.setIngredientName("IDs do not match, ingredient not updated");
            return ingredient;
        }
        ingredientDao.updateIngredient(ingredient);
        return ingredientDao.findIngredientById(id);
    }

    @Override
    public void deleteIngredientById(int id) {
        ingredientDao.deleteIngredient(id);
        System.out.println("Ingredient ID: " + id + " deleted");
    }
}
