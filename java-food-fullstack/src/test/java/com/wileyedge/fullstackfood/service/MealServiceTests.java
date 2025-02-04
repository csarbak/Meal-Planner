package com.wileyedge.fullstackfood.service;


import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MealServiceTests {
    private MealServiceImpl mealService;

    public MealServiceTests() {
        MealDao mealDao = new MealDaoStubImpl();
        mealService = new MealServiceImpl(mealDao);
    }

    @Test
    @DisplayName("Find Meal Service test")
    public void findMealServiceTest() {
        Meal returnMeal = mealService.getMealById(216);
        assertNotNull(returnMeal);
        assertEquals("Service Meal Dao Stub", returnMeal.getMealName());
    }

    @Test
    @DisplayName("Meal Not Found Service Test")
    public void mealNotFoundServiceTest() {
        Meal notFound = mealService.getMealById(137);
        assertNotNull(notFound);
        assertEquals("Meal Not Found", notFound.getMealName());
    }

    @Test
    @DisplayName("Update Meal Service Test")
    public void updateMealServiceTest() {
        Meal meal = new Meal();
        meal.setMealId(216);
        meal.setMealName("Updated Meal Name");
        meal.setMealDesc("Updated Meal Desc");
        meal.setUserId(13);

        mealService.updateMealData(216, meal);
        Meal updatedMeal;
        updatedMeal = mealService.getMealById(216);
        assertNotNull(updatedMeal);
        assertEquals(216, updatedMeal.getMealId());
        assertEquals("Updated Meal Name", updatedMeal.getMealName());
        assertEquals("Updated Meal Desc", updatedMeal.getMealDesc());
        assertEquals(13, updatedMeal.getUserId());
    }

    @Test
    @DisplayName("Meal Not Updated Service Test")
    public void mealNotUpdatedServiceTest() {
        Meal meal = new Meal();
        meal.setMealId(216);
        meal.setMealName("Updated Meal Name");
        meal.setMealDesc("Updated Meal Desc");
        meal.setUserId(13);

        mealService.updateMealData(99, meal);
        assertEquals("IDs do not match, meal not updated", meal.getMealName());
        assertEquals("IDs do not match, meal not updated", meal.getMealDesc());
    }

    @Test
    @DisplayName("Add Meal Service Test")
    public void addMealServiceTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("New Ingredient Name");
        Meal meal = new Meal();
        meal.setMealName("New Meal Name");
        meal.setMealDesc("New Meal Desc");
        meal.setMealId(3);
        HashMap<Ingredient, BigDecimal> ingredients = new HashMap<>();
        ingredients.put(ingredient, new BigDecimal("0.5"));
        meal.setIngredients(ingredients);
        Meal newMeal = mealService.addNewMeal(meal);
        assertNotNull(newMeal);
        assertEquals("New Meal Name", newMeal.getMealName());
        assertEquals("New Meal Desc", newMeal.getMealDesc());
    }

    @Test
    @DisplayName("Meal Not Added Service Test")
    public void mealNotAddedServiceTest() {
        Meal meal = new Meal();
        meal.setMealName("");
        meal.setMealDesc("");
        meal.setUserId(0);
        meal.setIngredients(new HashMap<>());
        mealService.addNewMeal(meal);
        assertEquals("Name blank, meal NOT added", meal.getMealName());
        assertEquals("Description blank, meal NOT added", meal.getMealDesc());
        assertEquals(-1, meal.getUserId());
        assertNull(meal.getIngredients().get(0));

    }
}
