package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.MealDao;
import com.wileyedge.fullstackfood.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealServiceImpl implements MealServiceInterface {

    @Autowired
    MealDao mealDao;

    public MealServiceImpl(MealDao mealDao) {
        this.mealDao = mealDao;
    }
    @Override
    public List<Meal> getAllMeals() {
        return mealDao.getAllMeals();
    }

    @Override
    public Meal getMealById(int id) {
        try {
            return mealDao.findMealById(id);
        } catch (DataAccessException e) {
            Meal mealNotFound = new Meal();
            mealNotFound.setMealName("Meal Not Found");
            mealNotFound.setMealDesc("Meal Not Found");
            return mealNotFound;
        }
    }

    @Override
    public Meal addNewMeal(Meal meal) {
        if (meal.getMealName().isBlank()) {
            meal.setMealDesc("Name blank, meal NOT added");

        }
        else if (meal.getMealDesc().isBlank()) {
            meal.setMealDesc("Description blank, meal NOT added");
        }
        return mealDao.addNewMeal(meal);
    }

    @Override
    public Meal updateMealData(int id, Meal meal) {
        if (id != meal.getMealId()) {
            meal.setMealName("IDs do not match, meal not updated");
            meal.setMealDesc("IDs do not match, meal not updated");
            return meal;
        }
        mealDao.updateMeal(meal);
        return mealDao.findMealById(id);
    }

    @Override
    public void deleteMealById(int id) {
        mealDao.deleteMeal(id);
        System.out.println("Meal ID: " + id + " deleted");
    }
}
