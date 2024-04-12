package com.wileyedge.fullstackfood.controller;

import com.wileyedge.fullstackfood.model.Ingredient;
import com.wileyedge.fullstackfood.model.Meal;
import com.wileyedge.fullstackfood.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewMeal(@RequestBody LinkedHashMap o) {
        //unpack meal

        Meal meal = new Meal();
        meal.setMealName(o.get("mealName").toString());
        meal.setMealDesc(o.get("mealDesc").toString());
        meal.setUserId(Integer.parseInt(o.get("userId").toString()));

        if (meal.getMealName().isBlank()) {
            return "Meal Name Blank. Meal Not Added";
        }

        if (meal.getMealDesc().isBlank()){
            return "Meal Desc Blank. Meal Not Added";
        }

        try {
            List<?> olist = (ArrayList<?>) o.get("ingredients");
            HashMap<Ingredient, BigDecimal> ingredientsMap = new HashMap<>();

            for (Object idQuantPair : olist) {
                Ingredient newIngredient = new Ingredient();
                Map.Entry<?, ?> idQuantPairEntry = ((LinkedHashMap<?, ?>) idQuantPair).entrySet().iterator().next();
                newIngredient.setIngredientId(Integer.parseInt(idQuantPairEntry.getKey().toString()));
                ingredientsMap.put(newIngredient, new BigDecimal(idQuantPairEntry.getValue().toString()));
            }
            meal.setIngredients(ingredientsMap);

            String resultMsg = "Meal Added! \n" + "Meal Has Ingredients: \n";
            for (Map.Entry<Ingredient, BigDecimal> ingredientQuantPair : ingredientsMap.entrySet()) {
                resultMsg += "--Ingredient ID: " + ingredientQuantPair.getKey().getIngredientId() + " With Quantity: " + ingredientQuantPair.getValue() + " grams\n";
            }

            if (ingredientsMap.isEmpty()){
                return "Meal Not Added. Please Include At Least One Ingredient!";
            }

            mealService.addNewMeal(meal);
            return resultMsg;

        } catch (NullPointerException ex) {
            return "Meal Not Added. Please Include At Least One Ingredient!";
        }

    }

    @PutMapping("/{id}")
    public String updateMealData(@PathVariable int id, @RequestBody LinkedHashMap o) {
        Meal meal = new Meal();
        meal.setMealId(Integer.parseInt(o.get("mealId").toString()));
        meal.setMealName(o.get("mealName").toString());
        meal.setMealDesc(o.get("mealDesc").toString());
        meal.setUserId(Integer.parseInt(o.get("userId").toString()));

        if (meal.getMealId() != id) {
            return "IDs do not match. Meal not Updated!";
        }

        try {
            List<?> olist = (ArrayList<?>) o.get("ingredients");
            HashMap<Ingredient, BigDecimal> ingredientsMap = new HashMap<>();

            for (Object idQuantPair : olist) {
                Ingredient newIngredient = new Ingredient();
                Map.Entry<?, ?> idQuantPairEntry = ((LinkedHashMap<?, ?>) idQuantPair).entrySet().iterator().next();
                newIngredient.setIngredientId(Integer.parseInt(idQuantPairEntry.getKey().toString()));
                ingredientsMap.put(newIngredient, new BigDecimal(idQuantPairEntry.getValue().toString()));
            }
            meal.setIngredients(ingredientsMap);

            String resultMsg = "Updated Meal With Meal ID: " + id + "! \n" + "Meal Has Ingredients: \n";
            for (Map.Entry<Ingredient, BigDecimal> ingredientQuantPair : ingredientsMap.entrySet()) {
                resultMsg += "--Ingredient ID: " + ingredientQuantPair.getKey().getIngredientId() + " With Quantity: " + ingredientQuantPair.getValue() + " grams\n";
            }

            if (ingredientsMap.isEmpty()){
                return "Meal Not Updated. Please Include At Least One Ingredient!";
            }

            mealService.updateMealData(id, meal);
            return resultMsg;

        } catch (NullPointerException ex) {
            return "Meal Not Updated. Please Include At Least One Ingredient!";
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMealById(@PathVariable int id) {
        mealService.deleteMealById(id);
    }


}
