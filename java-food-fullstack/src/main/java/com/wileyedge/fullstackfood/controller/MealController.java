package com.wileyedge.fullstackfood.controller;

import com.wileyedge.fullstackfood.model.Meal;
import com.wileyedge.fullstackfood.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@CrossOrigin
public class MealController {
    @Autowired
    MealService mealService;

    @GetMapping("/meals")
    List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable int id) {
        return mealService.getMealById(id);
    }

    @PostMapping("/add")
    public Meal addNewMeal(@RequestBody Meal meal) {
        return mealService.addNewMeal(meal);
    }

    @PutMapping("/{id}")
    public Meal updateMealData(@PathVariable int id, @RequestBody Meal meal) {
        return mealService.updateMealData(id, meal);
    }

    @DeleteMapping("/{id}")
    public void deleteMealById(@PathVariable int id) {
        mealService.deleteMealById(id);
    }


}
