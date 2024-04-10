package com.wileyedge.fullstackfood.dao;



import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJdbcTest //This makes each test transactional, so changes to the db get rolled back after each test
public class MealDaoImplTests {

    private JdbcTemplate jdbcTemplate;
    private MealDao mealDao;

    @Autowired
    public void CourseDaoImplTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        mealDao = new MealDaoImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Create New Meal Test")
    public void createNewMealTest() {
        Meal meal = new Meal();
        meal.setMealName("New Meal");
        meal.setMealDesc("This is a new meal");
        meal.setUserId(2);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("sugar");
        ingredient.setCaloriesPerGram(new BigDecimal("1.0"));

        ingredients.add(ingredient);
        meal.setIngredients(ingredients);
        mealDao.addNewMeal(meal);
        List<Meal> mealList = mealDao.getAllMeals();

        if(mealList.isEmpty()){System.out.println("empty");}
//        mealList.forEach((e) -> {
//            System.out.print(e + ", ");
//        });
        assertNotNull(mealList);
        assertEquals(31, mealList.size());
    }

    @Test
    @DisplayName("Get All Meals Test")
    public void getAllMealsTest() {
        List<Meal> newList = mealDao.getAllMeals();
        assertNotNull(newList);
        //assertEquals();
    }




}
