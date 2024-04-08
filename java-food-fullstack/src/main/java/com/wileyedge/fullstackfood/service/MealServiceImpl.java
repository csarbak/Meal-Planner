package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealServiceImpl implements MealServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    MealDao mealDao;


    @Override
    public List<Meal> getAllMeals() {
        return null;
    }

    @Override
    public Meal getMealById(int id) {
        return null;
    }

    @Override
    public Meal addNewMeal(Meal meal) {
        return null;
    }

    @Override
    public Meal updateMealData(int id, Meal meal) {
        return null;
    }

    @Override
    public void deleteMealById(int id) {

    }
}
