package com.wileyedge.fullstackfood.service;


import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

        Meal updatedMeal = mealService.updateMealData(216, meal);
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
        Meal meal = new Meal();
        meal.setMealName("New Meal Name");
        meal.setMealDesc("New Meal Desc");
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
        mealService.addNewMeal(meal);
        assertEquals("Name blank, meal NOT added", meal.getMealName());
        assertEquals("Description blank, meal NOT added", meal.getMealDesc());
        assertEquals(-1, meal.getUserId());
    }
}
