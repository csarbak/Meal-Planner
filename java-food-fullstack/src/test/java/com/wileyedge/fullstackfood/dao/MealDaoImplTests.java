
package com.wileyedge.fullstackfood.dao;


import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

@DataJdbcTest //This makes each test transactional, so changes to the db get rolled back after each test
public class MealDaoImplTests {

    private JdbcTemplate jdbcTemplate;
    private MealDao mealDao;

    @Autowired
    public void MealDaoImplTests(JdbcTemplate jdbcTemplate) {
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
        HashMap<Ingredient, BigDecimal> ingredients = new HashMap<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(10);

        ingredients.put(ingredient, new BigDecimal("0.1"));
        meal.setIngredients(ingredients);
        mealDao.addNewMeal(meal);
        List<Meal> mealList = mealDao.getAllMeals();


        assertNotNull(mealList);
        assertEquals(31, mealList.size());

    }

    @Test
    @DisplayName("Get All Meals Test")
    public void getAllMealsTest() {
        List<Meal> mealsList  = mealDao.getAllMeals();
        assertNotNull(mealsList);
        assertEquals(30, mealsList.size());
    }


    @Test
    @DisplayName("Find A Meal By ID: 25 Test")
    public void findAMealById25Test() {
        Meal meal = mealDao.findMealById(25);
        assertNotNull(meal);
        assertEquals("Breakfast", meal.getMealName());
        assertEquals("Bagel with Cream Cheese", meal.getMealDesc());
        assertEquals(9, meal.getUserId());
    }

    @Test
    @DisplayName("Meal Has Complete Ingredients List Test ( getIngredientsFromMeal() Test )")
    public void mealHasCompleteIngredientsListTest() {
        Meal meal = mealDao.findMealById(9);
        assertNotNull(meal);

        HashMap<Ingredient, BigDecimal> ingredientsMap = meal.getIngredients();
        assertNotNull(ingredientsMap);
        assertEquals(3, ingredientsMap.size()); //Assert that there are 3 ingredients associated with meal 9

        Set<Ingredient> ingredients = ingredientsMap.keySet(); //Check if one of the ingredients is Wheat Bread
        Ingredient wheatBread = new Ingredient();
        wheatBread.setIngredientId(4);
        wheatBread.setIngredientName("Wheat Bread");
        wheatBread.setCaloriesPerGram(new BigDecimal("2.74"));
        wheatBread.setFatsPerGram(new BigDecimal("0.05"));
        wheatBread.setProteinsPerGram(new BigDecimal("0.11"));
        wheatBread.setCarbohydratesPerGram(new BigDecimal("0.48"));
        assertTrue(ingredients.contains(wheatBread));

        Ingredient butter = new Ingredient(); //Check if one of the ingredients is butter
        butter.setIngredientId(14);
        butter.setIngredientName("Butter Light Stick Without Salt");
        butter.setCaloriesPerGram(new BigDecimal("4.99"));
        butter.setFatsPerGram(new BigDecimal("0.55"));
        butter.setProteinsPerGram(new BigDecimal("0.03"));
        butter.setCarbohydratesPerGram(new BigDecimal("0.00"));
        assertTrue(ingredients.contains(butter));

        Ingredient mozzarella = new Ingredient(); //Check if one of the ingredients is mozzarella
        mozzarella.setIngredientId(9);
        mozzarella.setIngredientName("Mozzarella Cheese (Non-Fat Or Fat Free)");
        mozzarella.setCaloriesPerGram(new BigDecimal("1.41"));
        mozzarella.setFatsPerGram(new BigDecimal("0.00"));
        mozzarella.setProteinsPerGram(new BigDecimal("0.32"));
        mozzarella.setCarbohydratesPerGram(new BigDecimal("0.04"));
        assertTrue(ingredients.contains(mozzarella));

    }

    @Test
    @DisplayName("Meal Has Correct Nutrient Totals Test")
    public void mealHasCorrectNutrientTotalsTest() {
        Meal meal = mealDao.findMealById(25);

        //The BigDecimal literals that are used for comparison here are pre-computed nutrient/calorie totals with formula:
        // Total = QuantityRatio * [nutrients | calories] per gram
        // e.g. The QuantityRatios for this meal are
        // 100g of Wheat Bread at 2.74 cal/g
        // 50g of Mozzarella at 1.41 cal/g
        // 50g of Honey at 3.04 cal/g
        //so totalCalories = (100 * 2.74) + (50 * 1.41) + (50 * 3.04) = 496.50

        assertThat(new BigDecimal("496.50"), Matchers.comparesEqualTo(meal.getTotalCalories()));
        assertThat(new BigDecimal("5.00"), Matchers.comparesEqualTo(meal.getTotalFats()));
        assertThat(new BigDecimal("27.00"), Matchers.comparesEqualTo(meal.getTotalProteins()));
        assertThat(new BigDecimal("91.00"), Matchers.comparesEqualTo(meal.getTotalCarbohydrates()));

    }

    @Test
    @DisplayName("Update Meal Info Test")
    public void updateMealInfoTest() {
        Meal premealCheck = mealDao.findMealById(23);
        assertEquals(3, premealCheck.getIngredients().size());

        //First we'll update all fields except for ingredient
        Meal preUpdateMeal = new Meal();
        preUpdateMeal.setMealId(23);
        preUpdateMeal.setMealDesc("Beef. Only Beef.");
        preUpdateMeal.setMealName("Lunch");
        preUpdateMeal.setUserId(9);

        //Then, we will change the size and contents of the ingredients map associated with the meal. We're changing the # Ingredients from 3 to 1 (deleting all ingredients, and adding 1)
        Ingredient beef = new Ingredient();
        beef.setIngredientId(22);
        beef.setIngredientName("Ground Beef Cooked");
        beef.setCaloriesPerGram(new BigDecimal("2.60"));
        beef.setFatsPerGram(new BigDecimal("0.17"));
        beef.setProteinsPerGram(new BigDecimal("0.26"));
        beef.setCarbohydratesPerGram(new BigDecimal("0.00"));

        HashMap<Ingredient, BigDecimal> newIngredientsMap = new HashMap<>();
        newIngredientsMap.put(beef, new BigDecimal("400.00")); // 400 grams of beef please!
        preUpdateMeal.setIngredients(newIngredientsMap);

        mealDao.updateMeal(preUpdateMeal);

        Meal postUpdateMeal = mealDao.findMealById(23);
        assertEquals("Lunch", postUpdateMeal.getMealName());
        assertEquals("Beef. Only Beef.", postUpdateMeal.getMealDesc());
        assertEquals(9, postUpdateMeal.getUserId());
        assertEquals(1, postUpdateMeal.getIngredients().size());
    }

    @Test
    @DisplayName("Delete Meal Test")
    public void deleteMealTest() {
        mealDao.deleteMeal(1);
        assertNotNull(mealDao.getAllMeals());
        assertEquals(29, mealDao.getAllMeals().size());
    }


}

