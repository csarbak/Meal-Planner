package com.wileyedge.fullstackfood.dao;

import com.wileyedge.fullstackfood.model.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest //This makes each test transactional, so changes to the db get rolled back after each test
public class IngredientDaoImplTests {
    private JdbcTemplate jdbcTemplate;
    private IngredientDao ingredientDao;

    @Autowired
    public void IngredientDaoImplTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        ingredientDao = new IngredientDaoImpl(jdbcTemplate);
    }


    @Test
    @DisplayName("Add New Ingredient Test")
    public void addNewIngredientTest() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("New Ingredient");
        ingredient.setCaloriesPerGram(new BigDecimal(9.69));
        ingredient.setProteinsPerGram(new BigDecimal(0.50));
        ingredient.setFatsPerGram(new BigDecimal(0.03));
        ingredient.setCarbohydratesPerGram(new BigDecimal(0.73));
        ingredientDao.createNewIngredient(ingredient);
        List<Ingredient> newList = ingredientDao.getAllIngredients();
        assertNotNull(newList);
        assertEquals(36, newList.size());
    }


    @Test
    @DisplayName("Get A List of All Ingredients Test")
    public void getListOfAllIngredientsTest(){
        List<Ingredient> newList = ingredientDao.getAllIngredients();
        assertNotNull(newList);
        assertEquals(35, newList.size());
    }

    @Test
    @DisplayName("Find Ingredient By Id: 15 Test")
    public void findIngredientByIdTest() {
        Ingredient ingredient = ingredientDao.findIngredientById(15);
        assertNotNull(ingredient);
        assertEquals("Olive Oil", ingredient.getIngredientName());
        assertEquals(new BigDecimal("8.84"), ingredient.getCaloriesPerGram());
        assertEquals(new BigDecimal("1.00"), ingredient.getFatsPerGram());
        assertEquals(new BigDecimal("0.00"), ingredient.getProteinsPerGram());
        assertEquals(new BigDecimal("0.00"), ingredient.getCarbohydratesPerGram());
    }


    @Test
    @DisplayName("Update Ingredient Info Test")
    public void updateIngredientInfoTest(){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(1);
        ingredient.setIngredientName("Dee'sNutsTM");
        ingredient.setCaloriesPerGram(new BigDecimal("69"));
        ingredient.setFatsPerGram(new BigDecimal("0.420"));
        ingredient.setProteinsPerGram(new BigDecimal("0.69"));
        ingredient.setCarbohydratesPerGram(new BigDecimal("0.20"));
        ingredientDao.updateIngredient(ingredient);
        List<Ingredient> newList = ingredientDao.getAllIngredients();
        assertNotNull(newList);
        int i = 0;
        for (Ingredient ing : newList) {
            if (ing.getIngredientName().contains("Dee'sNutsTM") &&
                    ing.getCaloriesPerGram().equals(new BigDecimal("69.00")) &&
                    ing.getFatsPerGram().equals(new BigDecimal("0.42")) &&
                    ing.getProteinsPerGram().equals(new BigDecimal("0.69")) &&
                    ing.getCarbohydratesPerGram().equals(new BigDecimal("0.20"))) {
                i++;
            }
        }
        assertTrue(i != 0);
    }

    @Test
    @DisplayName("Delete Ingredient Test")
    @Transactional
    public void deleteIngredientTest(){
        ingredientDao.deleteIngredient(5);
        assertNotNull(ingredientDao.getAllIngredients());
        assertEquals(34, ingredientDao.getAllIngredients().size());
    }





}
