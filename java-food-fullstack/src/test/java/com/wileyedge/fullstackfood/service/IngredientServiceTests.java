package com.wileyedge.fullstackfood.service;

import com.wileyedge.fullstackfood.dao.IngredientDao;
import com.wileyedge.fullstackfood.model.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngredientServiceTests {
    private IngredientServiceImpl ingredientService;

    public IngredientServiceTests() {
        IngredientDao ingredientDao = new IngredientDaoStubImpl();
        ingredientService = new IngredientServiceImpl(ingredientDao);
    }

    @Test
    @DisplayName("Find Ingredient Service Test")
    public void findIngredientServiceTest() {
        Ingredient returnIngredient = ingredientService.getIngredientById(100);
        assertNotNull(returnIngredient);
        assertEquals("40 Foot Tall Test Carrot", returnIngredient.getIngredientName());
    }

    @Test
    @DisplayName("Ingredient Not Found Service Test")
    public void ingredientNotFoundServiceTest() {
        Ingredient notFound = ingredientService.getIngredientById(99);
        assertNotNull(notFound);
        assertEquals("Ingredient Not Found", notFound.getIngredientName());
    }

    @Test
    @DisplayName("Update Ingredient Service Test")
    public void updateCourseServiceTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(100);
        ingredient.setIngredientName("Updated Ingredient Name");

        Ingredient updatedIngredient = ingredientService.updateIngredientData(100, ingredient);
        assertEquals(100, updatedIngredient.getIngredientId());
        assertNotNull(updatedIngredient);
        assertEquals("Updated Ingredient Name", updatedIngredient.getIngredientName());
    }

    @Test
    @DisplayName("Ingredient Not Updated Service Test")
    public void ingredientNotUpdatedServiceTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(100);
        ingredient.setIngredientName("Updated Ingredient First Name");

        Ingredient updatedIngredient = ingredientService.updateIngredientData(99, ingredient);
        assertEquals("IDs do not match, ingredient not updated", ingredient.getIngredientName());
    }

    @Test
    @DisplayName("Ingredient Add Service Test")
    public void ingredientAddServiceTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("New Ingredient Name");

        Ingredient newIngredient = ingredientService.addNewIngredient(ingredient);
        assertNotNull(newIngredient);
        assertEquals("New Ingredient Name", newIngredient.getIngredientName());
    }

    @Test
    @DisplayName("Ingredient Not Added Service Test")
    public void ingredientNotAddedServiceTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("");
        Ingredient newIngredient = ingredientService.addNewIngredient(ingredient);
        assertEquals("Name blank, ingredient NOT added", ingredient.getIngredientName());
    }

}
