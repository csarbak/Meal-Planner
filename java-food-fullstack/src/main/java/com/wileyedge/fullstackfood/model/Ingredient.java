package com.wileyedge.fullstackfood.model;

import java.math.BigDecimal;

public class Ingredient {

    private String ingredientName;

    private int ingredientId;

    private BigDecimal caloriesPerGram;

    private BigDecimal proteinsPerGram;

    private BigDecimal fatsPerGram;

    private BigDecimal carbohydratesPerGram;

    public BigDecimal getCaloriesPerGram() {
        return caloriesPerGram;
    }

    public void setCaloriesPerGram(BigDecimal caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    public BigDecimal getProteinsPerGram() {
        return proteinsPerGram;
    }

    public void setProteinsPerGram(BigDecimal proteinsPerGram) {
        this.proteinsPerGram = proteinsPerGram;
    }

    public BigDecimal getFatsPerGram() {
        return fatsPerGram;
    }

    public void setFatsPerGram(BigDecimal fatsPerGram) {
        this.fatsPerGram = fatsPerGram;
    }

    public BigDecimal getCarbohydratesPerGram() {
        return carbohydratesPerGram;
    }

    public void setCarbohydratesPerGram(BigDecimal carbohydratesPerGram) {
        this.carbohydratesPerGram = carbohydratesPerGram;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }



}
