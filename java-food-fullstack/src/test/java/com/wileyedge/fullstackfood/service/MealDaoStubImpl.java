package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Meal;
import java.util.List;

public class MealDaoStubImpl implements MealDao {

    public Meal onlyMeal;



    @Override
    public Meal createNewMeal(Meal meal) {
        return null;
    }

    @Override
    public List<Meal> getAllMeals() {
        return null;
    }

    @Override
    public Meal findMealById(int id) {
        return null;
    }

    @Override
    public void updateMeal(Meal meal) {

    }

    @Override
    public void deleteMeal(int id) {

    }

    @Override
    public void deleteAllIngredientsFromMeal(int MealId) {

    }
}