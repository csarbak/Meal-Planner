package com.wileyedge.fullstackfood.controller;

import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredients")
    List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable int id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/add")
    public Ingredient addNewIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addNewIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredientData(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredientData(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredientById(@PathVariable int id) {
        ingredientService.deleteIngredientById(id);
    }

}
