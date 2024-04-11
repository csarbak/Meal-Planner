package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;

import java.math.BigDecimal;
import java.util.List;

public class MealDaoStubImpl implements MealDao {

    public Meal onlyMeal;

    public MealDaoStubImpl() {
        onlyMeal = new Meal();
        onlyMeal.setMealId(216);
        onlyMeal.setMealName("Service Meal Dao Stub");
        onlyMeal.setMealDesc("For Testing Purposes Only");
    }

    @Override
    public Meal addNewMeal(Meal meal) {
        if (meal.getMealName().isBlank() || meal.getMealDesc().isBlank()) {
            meal.setMealName("Name blank, meal NOT added");
            meal.setMealDesc("Description blank, meal NOT added");
        }
        return meal;
    }

    @Override
    public List<Meal> getAllMeals() {
        //Pass through. There's no code to test in this method
        return null;
    }

    @Override
    public Meal findMealById(int id) {
        if (onlyMeal.getMealId() != id) {
            onlyMeal.setMealName("Meal Not Found");
            onlyMeal.setMealDesc("Meal Not Found");
        }
        return onlyMeal;
    }

    @Override
    public void updateMeal(Meal meal) {
        onlyMeal.setMealName(meal.getMealName());
        onlyMeal.setMealDesc(meal.getMealDesc());
        onlyMeal.setMealId(meal.getMealId());
        onlyMeal.setUserId(meal.getUserId());
    }

    @Override
    public void deleteMeal(int id) {
        //Pass through. There's no code to test in this method
    }
}
