package com.wileyedge.fullstackfood.model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return ingredientId == that.ingredientId && Objects.equals(ingredientName, that.ingredientName) && Objects.equals(caloriesPerGram, that.caloriesPerGram) && Objects.equals(proteinsPerGram, that.proteinsPerGram) && Objects.equals(fatsPerGram, that.fatsPerGram) && Objects.equals(carbohydratesPerGram, that.carbohydratesPerGram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName, ingredientId, caloriesPerGram, proteinsPerGram, fatsPerGram, carbohydratesPerGram);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                '}' +  ", quantityRatioOfIngredient";
    }
}
