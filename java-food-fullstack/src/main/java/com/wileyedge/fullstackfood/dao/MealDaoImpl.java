package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.dao.mappers.MealIngredientMapper;
import com.wileyedge.fullstackfood.dao.mappers.MealMapper;
import com.wileyedge.fullstackfood.dao.mappers.UserMapper;
import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import com.wileyedge.fullstackfood.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

@Repository
public class MealDaoImpl implements MealDao {

    private final JdbcTemplate jdbcTemplate;

    public MealDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Meal addNewMeal(Meal meal) {
        final String INSERT_MEAL = "INSERT INTO meal(mealName, user_id, mealDesc ) VALUES(?,?,?)";
        jdbcTemplate.update(INSERT_MEAL,
                meal.getMealName(),
                meal.getUserId(),
                meal.getMealDesc());


        int newId = jdbcTemplate.queryForObject("SELECT LASTVAL()", Integer.class);
        meal.setMealId(newId);

        insertMealIngredient(meal);

        meal.setTotalFats(calculateTotalFats(meal.getMealId()));
        meal.setTotalProteins(calculateTotalProteins(meal.getMealId()));
        meal.setTotalCarbohydrates(calculateTotalCarbohydrates(meal.getMealId()));
        meal.setTotalCalories(calculateTotalCalories(meal.getMealId()));

        return meal;
    }

    @Override
    public List<Meal> getAllMeals() {
        final String SELECT_ALL_MEALS = "SELECT * FROM meal";
        List<Meal> meals = jdbcTemplate.query(SELECT_ALL_MEALS, new MealMapper());
        addIngredientsToMeals(meals);
        return meals;
    }

    private void addIngredientsToMeals(List<Meal> meals) {
        for(Meal meal : meals) {
            meal.setUserId(getUserForMeal(meal).getUserId());
            meal.setIngredients(getIngredientsFromMeal(meal.getMealId()));
            meal.setTotalFats(calculateTotalFats(meal.getMealId()));
            meal.setTotalProteins(calculateTotalProteins(meal.getMealId()));
            meal.setTotalCarbohydrates(calculateTotalCarbohydrates(meal.getMealId()));
            meal.setTotalCalories(calculateTotalCalories(meal.getMealId()));
        }
    }

    @Override
    public Meal findMealById(int id) {
        try {
            final String SELECT_MEAL_BY_ID = "SELECT * FROM meal WHERE mealId = ?";
            Meal meal = jdbcTemplate.queryForObject(SELECT_MEAL_BY_ID, new MealMapper(), id);
            assert meal != null;
            meal.setTotalCalories(calculateTotalCalories(id));
            meal.setTotalProteins(calculateTotalProteins(id));
            meal.setTotalFats(calculateTotalFats(id));
            meal.setTotalCarbohydrates(calculateTotalCarbohydrates(id));
            meal.setIngredients(getIngredientsFromMeal(id));
            meal.setUserId(getUserForMeal(meal).getUserId());
            return meal;

        } catch(DataAccessException ex) {

            throw ex;
        }
    }

    //Update here

    public HashMap<Ingredient, BigDecimal > getIngredientsFromMeal(int mealId) {
        HashMap<Ingredient, BigDecimal > map = new HashMap<>();
        final String SELECT_INGREDIENTS_FOR_MEAL = "SELECT i.* , mi.quantityRatioOfIngredient FROM ingredient i "
                + "JOIN meal_ingredient mi ON i.ingredientId = mi.ingredient_id WHERE mi.meal_id = ?";
        List<AbstractMap.SimpleEntry<Ingredient, BigDecimal>> smLst = jdbcTemplate.query(SELECT_INGREDIENTS_FOR_MEAL, new MealIngredientMapper(),
                mealId);
        for (AbstractMap.SimpleEntry<Ingredient, BigDecimal> sm: smLst){
            map.put(sm.getKey(),sm.getValue());
        }
        return map;
    }

    @Override
    @Transactional
    public void updateMeal(Meal meal) {
        final String UPDATE_Meal = "UPDATE meal SET mealName = ?, mealDesc = ?, user_id =?  WHERE mealId = ?";
        jdbcTemplate.update(UPDATE_Meal,
                meal.getMealName(),
                meal.getMealDesc(),
                meal.getUserId(),
                meal.getMealId());


        final String DELETE_MEAL_INGREDIENT = "DELETE FROM meal_ingredient "
                + "WHERE meal_id = ?";
        jdbcTemplate.update(DELETE_MEAL_INGREDIENT, meal.getMealId());
        insertMealIngredient(meal);

    }

    private void insertMealIngredient(Meal meal) {
        final String INSERT_MEAL_INGREDIENT = "INSERT INTO meal_ingredient"
                + "(ingredient_id, meal_id, quantityRatioOfIngredient) VALUES(?,?, ?)";
        for(Ingredient ingredient : meal.getIngredients().keySet()) {
            jdbcTemplate.update(INSERT_MEAL_INGREDIENT, ingredient.getIngredientId() , meal.getMealId(), meal.getIngredients().get(ingredient)  );
        }
    }

    @Override
    public void deleteMeal(int id) {
        final String DELETE_MEAL_INGREDIENT = "DELETE FROM meal_ingredient "
                + "WHERE meal_id = ?";
        jdbcTemplate.update(DELETE_MEAL_INGREDIENT, id);

        final String DELETE_MEAL = "DELETE FROM meal WHERE mealId = ?";
        jdbcTemplate.update(DELETE_MEAL, id);

    }


    private User getUserForMeal(Meal meal) {
        final String SELECT_USER_FOR_MEAL = "SELECT u.* FROM user u "
                + "JOIN meal m ON u.userId = m.user_id WHERE m.mealId = ?";
        return jdbcTemplate.queryForObject(SELECT_USER_FOR_MEAL, new UserMapper(),
                meal.getMealId());
    }


    public BigDecimal calculateTotalCalories(int mealId) {
        HashMap<Ingredient, BigDecimal > mealIngredient = getIngredientsFromMeal(mealId);
        BigDecimal totalCalories = new BigDecimal("0");

        for(Ingredient ingredient : mealIngredient.keySet()) {
            totalCalories = totalCalories.add(ingredient.getCaloriesPerGram().multiply(mealIngredient.get(ingredient)));

        }
        return totalCalories;
    }



    public BigDecimal calculateTotalProteins(int mealId) {
        HashMap<Ingredient, BigDecimal > mealIngredient = getIngredientsFromMeal(mealId);
        BigDecimal totalProteins = new BigDecimal("0");

        for(Ingredient ingredient : mealIngredient.keySet()) {
            totalProteins = totalProteins.add(ingredient.getProteinsPerGram().multiply(mealIngredient.get(ingredient)));

        }
        return totalProteins;
    }


    public BigDecimal calculateTotalFats(int mealId) {
        HashMap<Ingredient, BigDecimal > mealIngredient = getIngredientsFromMeal(mealId);
        BigDecimal totalFats = new BigDecimal("0");

        for(Ingredient ingredient : mealIngredient.keySet()) {
            totalFats = totalFats.add(ingredient.getFatsPerGram().multiply(mealIngredient.get(ingredient)));

        }
        return totalFats;
    }


    public BigDecimal calculateTotalCarbohydrates(int mealId) {
        HashMap<Ingredient, BigDecimal >  mealIngredient = getIngredientsFromMeal(mealId);
        BigDecimal totalCarbohydrates = new BigDecimal("0");

        for(Ingredient ingredient : mealIngredient.keySet()) {
            totalCarbohydrates = totalCarbohydrates.add(ingredient.getCarbohydratesPerGram().multiply(mealIngredient.get(ingredient)));

        }
        return totalCarbohydrates;
    }


}

