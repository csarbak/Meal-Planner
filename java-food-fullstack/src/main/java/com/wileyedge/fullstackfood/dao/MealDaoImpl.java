package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.dao.mappers.IngredientMapper;
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
        return meal;
    }

    @Override
    public List<Meal> getAllMeals() {
        final String SELECT_ALL_Meals = "SELECT * FROM meal";
        List<Meal> meals = jdbcTemplate.query(SELECT_ALL_Meals, new MealMapper());
        addRoomAndEmployeesToMeetings(meals);
        return meals;
    }

    private void addRoomAndEmployeesToMeetings(List<Meal> meals) {
        for(Meal meal : meals) {
            meal.setUserId(getUserForMeal(meal).getUserId());
            meal.setIngredients(getIngredientsFromMeal(meal.getMealId()));
        }
    }

    @Override
    public Meal findMealById(int id) {
        try {
            final String SELECT_ROOM_BY_ID = "SELECT * FROM meal WHERE mealId = ?";
            Meal meal = jdbcTemplate.queryForObject(SELECT_ROOM_BY_ID, new MealMapper(), id);
            meal.setTotalCalories(calculateTotalCalories(id));
            meal.setTotalProteins(calculateTotalProteins(id));
            meal.setTotalFats(calculateTotalFats(id));
            meal.setTotalCarbohydrates(calculateTotalCarbohydrates(id));
            meal.setIngredients(getIngredientsFromMeal(id));
            meal.setUserId(getUserForMeal(meal).getUserId());
            return meal;

        } catch(DataAccessException ex) {
            return null;
        }
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


        final String DELETE_MEAL_INGREDENT = "DELETE FROM meal_ingredient "
                + "WHERE meal_id = ?";
        jdbcTemplate.update( DELETE_MEAL_INGREDENT, meal.getMealId());
        insertMealIngredient(meal);

    }

    private void insertMealIngredient(Meal meal) {
        final String INSERT_MEETING_EMPLOYEE = "INSERT INTO meal_ingredient"
                + "(ingredient_id, meal_id) VALUES(?,?)";
        for(Ingredient ingredient : meal.getIngredients()) {
            jdbcTemplate.update(INSERT_MEETING_EMPLOYEE, meal.getMealId(), ingredient.getIngredientId());
        }
    }

    @Override
    public void deleteMeal(int id) {


    }

    @Override
    public void deleteAllIngredientsFromMeal(int mealId) {

    }

    @Override
    public List<Ingredient> getIngredientsFromMeal(int mealId) {
        final String SELECT_EMPLOYEES_FOR_MEETING = "SELECT i.* FROM ingredient i "
                + "JOIN meal_ingredient mi ON i.ingredientId = mi.ingredient_id WHERE mi.meal_id = ?";
        return jdbcTemplate.query(SELECT_EMPLOYEES_FOR_MEETING, new IngredientMapper(),
                mealId);
    }

    private User getUserForMeal(Meal meal) {
        final String SELECT_ROOM_FOR_MEETING = "SELECT u.* FROM user u "
                + "JOIN meal m ON u.userId = m.user_id WHERE m.mealId = ?";
        return jdbcTemplate.queryForObject(SELECT_ROOM_FOR_MEETING, new UserMapper(),
                meal.getMealId());
    }

    @Override
    public BigDecimal calculateTotalCalories(int mealId) {
        List<Ingredient> mealIngred = getIngredientsFromMeal(mealId);
        BigDecimal totalCaloris = new BigDecimal("0");

        for(Ingredient ingredient : mealIngred){
            //Sum up all calories here
        }
        return totalCaloris;
    }

    @Override
    public BigDecimal calculateTotalProteins(int mealId) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalFats(int mealId) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalCarbohydrates(int mealId) {
        return null;
    }


}
