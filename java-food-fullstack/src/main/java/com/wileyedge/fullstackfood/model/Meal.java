package com.wileyedge.fullstackfood.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class Meal {

    private int mealId;

    private String mealName;

    private String mealDesc;

    private int userId;

    private BigDecimal totalCalories;

    private BigDecimal totalProteins;

    private BigDecimal totalFats;

    private BigDecimal totalCarbohydrates;

    private HashMap<Ingredient, Double > ingredients;

    public HashMap<Ingredient, Double > getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Double > ingredients) {
        this.ingredients = ingredients;
    }



    public BigDecimal getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(BigDecimal totalCalories) {
        this.totalCalories = totalCalories;
    }

    public BigDecimal getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(BigDecimal totalProteins) {
        this.totalProteins = totalProteins;
    }

    public BigDecimal getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(BigDecimal totalFats) {
        this.totalFats = totalFats;
    }

    public BigDecimal getTotalCarbohydrates() {
        return totalCarbohydrates;
    }

    public void setTotalCarbohydrates(BigDecimal totalCarbohydrates) {
        this.totalCarbohydrates = totalCarbohydrates;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getMealDesc() {
        return mealDesc;
    }

    public void setMealDesc(String mealDesc) {
        this.mealDesc = mealDesc;
    }


    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }


    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

}
