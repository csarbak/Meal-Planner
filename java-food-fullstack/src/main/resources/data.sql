
INSERT INTO user (userId, userFName, userLName) VALUES
(1, 'John', 'Doe'),
(2, 'Jane', 'Smith'),
(3, 'Alice', 'Johnson'),
(4, 'Bob', 'Brown'),
(5, 'Emma', 'Wilson'),
(6, 'Michael', 'Jones'),
(7, 'Sophia', 'Miller'),
(8, 'William', 'Taylor'),
(9, 'Olivia', 'Anderson'),
(10, 'James', 'Martinez');

INSERT INTO meal (mealId, mealName, user_id, mealDesc) VALUES
(1, 'Breakfast', 1, 'Omelette'),
(2, 'Lunch', 1, 'Chicken Salad'),
(3, 'Dinner', 1, 'Spaghetti Carbonara'),

(4, 'Snack', 2, 'Apple Slices with Peanut Butter'),
(5, 'Brunch', 2, 'Avocado Toast'),
(6, 'Dinner', 2, 'Beef Stir Fry'),

(7, 'Lunch', 3, 'Tofu Sandwich'),
(8, 'Breakfast', 3, 'Yogurt and Granola'),
(9, 'Dinner', 3, 'Grilled Cheese Sandwich'),

(10, 'Dinner', 4, 'Beef Tacos'),
(11, 'Snack', 4, 'Trail Mix'),
(12, 'Breakfast', 4, 'Pancakes'),

(13, 'Lunch', 5, 'Caesar Salad'),
(14, 'Dinner', 5, 'Chicken Alfredo'),
(15, 'Snack', 5, 'Greek Yogurt with Honey'),

(16, 'Brunch', 6, 'Breakfast Burrito'),
(17, 'Dinner', 6, 'Spicy Tofu Stir Fry'),
(18, 'Lunch', 6, 'Chicken Caesar Wrap'),

(19, 'Breakfast', 7, 'Fruit Smoothie'),
(20, 'Dinner', 7, 'Baked Salmon'),
(21, 'Snack', 7, 'Cheese and Crackers'),

(22, 'Breakfast', 8, 'Breakfast Bowl'),
(23, 'Dinner', 8, 'Vegetable Stir Fry'),
(24, 'Lunch', 8, 'Greek Salad'),

(25, 'Breakfast', 9, 'Bagel with Cream Cheese'),
(26, 'Dinner', 9, 'Chicken Teriyaki'),
(27, 'Snack', 9, 'Ants on a Log'),

(28, 'Brunch', 10, 'Breakfast Wrap'),
(29, 'Dinner', 10, 'BBQ Chicken'),
(30, 'Snack', 10, 'Caprese Skewers');


INSERT INTO ingredient (ingredientId, ingredientName, caloriesPerGram, fatsPerGram, proteinsPerGram, carbohydratesPerGram) VALUES
(1, 'Taco Shells Baked', 4.76, 0.2179, 0.0641, 0.6349),
(2, 'Mission Foods Mission Flour Tortillas Soft Taco 8 Inch', 2.87, 0.06, 0.087, 0.496),
(3, 'Rudis Gluten-Free Bakery Original Sandwich Bread', 3.2, 0.107, 0.0313, 0.5283),
(4, 'Wheat Bread', 2.74, 0.0453, 0.1067, 0.4754),
(5, 'Pinto Beans (Cooked)', 1.43, 0.0065, 0.0901, 0.2622),
(6, 'Soy Sauce', 0.53, 0.0057, 0.0814, 0.0493),
(7, 'Soft Tofu', 0.61, 0.0369, 0.0717, 0.0118),
(8, 'Granola Homemade', 4.89, 0.2431, 0.1367, 0.5388),
(9, 'Mozzarella Cheese (Non-Fat Or Fat Free)', 1.41, 0, 0.317, 0.035),
(10, 'Low-Fat Milk 1%', 0.42, 0.0097, 0.0337, 0.0499),
(11, 'Nonfat Greek Yogurt', 0.59, 0.0039, 0.1019, 0.036),
(12, 'Greek Yogurt (Plain)', 0.97, 0.05, 0.09, 0.0398),
(13, 'Egg Whole Cooked Ns As To Cooking Method', 1.79, 0.1354, 0.123, 0.011),
(14, 'Butter Light Stick Without Salt', 4.99, 0.551, 0.033, 0),
(15, 'Olive Oil', 8.84, 1, 0, 0),
(16, 'Mayonnaise Reduced Fat With Olive Oil', 3.61, 0.4, 0.0037, 0),
(17, 'Crustaceans Shrimp Cooked (Not Previously Frozen)', 0.99, 0.0028, 0.2398, 0.002),
(18, 'Lemon Juice From Concentrate Canned Or Bottled', 0.17, 0.0007, 0.0045, 0.0562),
(19, 'Strawberries', 0.32, 0.003, 0.0067, 0.0768),
(20, 'Avocados', 1.6, 0.1466, 0.02, 0.0853),
(21, 'White Rice', 1.3, 0.0028, 0.0269, 0.2817),
(22, 'Ground Beef Cooked', 2.6, 0.1682, 0.2554, 0),
(23, 'Raw Chicken Breast', 1.2, 0.0262, 0.225, 0),
(24, 'Pork Cured Bacon Cooked Baked', 5.48, 0.4327, 0.3573, 0.0135),
(25, 'Pepperoni', 5.04, 0.4628, 0.1925, 0.0118),
(26, 'Red Wine Vinegar', 0.19, 0, 0.0004, 0.0027),
(27, 'Honey', 3.04, 0, 0.003, 0.824),
(28, 'Cooked Lima Beans', 1.23, 0.0032, 0.0681, 0.2364),
(29, 'Romaine Lettuce', 0.17, 0.003, 0.0123, 0.0329),
(30, 'Baked Russet Potatoes', 0.95, 0.0013, 0.0263, 0.2144),
(31, 'Spinach', 0.23, 0.0039, 0.0286, 0.0363),
(32, 'Red Bell Peppers (Cooked)', 1.33, 0.1275, 0.0104, 0.0657),
(33, 'Sauteed Green Bell Peppers', 1.16, 0.1185, 0.0078, 0.0422),
(34, 'Tomato Sauce Canned No Salt Added', 0.24, 0.003, 0.012, 0.0531),
(35, 'Broccoli Cooked', 0.53, 0.0252, 0.0231, 0.0694);

-- Meal 1: Breakfast - Omelette
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(13, 1, 150.0), -- Egg Whole Cooked Ns As To Cooking Method
(7, 1, 50.0);   -- Soft Tofu

-- Meal 2: Lunch - Chicken Salad
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(29, 2, 100.0), -- Romaine Lettuce
(23, 2, 150.0), -- Raw Chicken Breast
(18, 2, 50.0);  -- Lemon Juice From Concentrate Canned Or Bottled

-- Meal 3: Dinner - Spaghetti Carbonara
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(3, 3, 200.0), -- Rudis Gluten-Free Bakery Original Sandwich Bread
(10, 3, 100.0), -- Low-Fat Milk 1%
(22, 3, 250.0), -- Ground Beef Cooked
(15, 3, 50.0); -- Olive Oil

-- Meal 4: Snack - Apple Slices with Peanut Butter
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(19, 4, 100.0), -- Strawberries
(15, 4, 50.0), -- Olive Oil
(28, 4, 50.0); -- Cooked Lima Beans

-- Meal 5: Brunch - Avocado Toast
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(20, 5, 100.0), -- Avocados
(4, 5, 100.0); -- Wheat Bread

-- Meal 6: Dinner - Beef Stir Fry
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(21, 6, 100.0), -- White Rice
(25, 6, 100.0), -- Pepperoni
(22, 6, 200.0); -- Ground Beef Cooked

-- Meal 7: Lunch - Tofu Sandwich
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(7, 7, 100.0), -- Soft Tofu
(3, 7, 100.0), -- Rudis Gluten-Free Bakery Original Sandwich Bread
(18, 7, 50.0); -- Lemon Juice From Concentrate Canned Or Bottled

-- Meal 8: Breakfast - Yogurt and Granola
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(11, 8, 100.0), -- Nonfat Greek Yogurt
(8, 8, 50.0), -- Granola Homemade
(19, 8, 50.0); -- Strawberries

-- Meal 9: Lunch - Grilled Cheese Sandwich
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(4, 9, 100.0), -- Wheat Bread
(14, 9, 50.0), -- Butter Light Stick Without Salt
(9, 9, 50.0); -- Mozzarella Cheese (Non-Fat Or Fat Free)

-- Meal 10: Dinner - Beef Tacos
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(1, 10, 100.0), -- Taco Shells Baked
(22, 10, 200.0), -- Ground Beef Cooked
(5, 10, 100.0); -- Pinto Beans (Cooked)

-- Meal 11: Snack - Trail Mix
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(20, 11, 100.0), -- Avocados
(25, 11, 50.0), -- Pepperoni
(29, 11, 50.0); -- Romaine Lettuce

-- Meal 12: Breakfast - Pancakes
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(12, 12, 100.0), -- Greek Yogurt (Plain)
(4, 12, 100.0), -- Wheat Bread
(27, 12, 50.0); -- Honey

-- Meal 13: Lunch - Caesar Salad
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(2, 13, 100.0), -- Mission Foods Mission Flour Tortillas Soft Taco 8 Inch
(17, 13, 150.0), -- Crustaceans Shrimp Cooked (Not Previously Frozen)
(18, 13, 50.0); -- Lemon Juice From Concentrate Canned Or Bottled

-- Meal 14: Dinner - Chicken Alfredo
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(21, 14, 100.0), -- White Rice
(23, 14, 200.0), -- Raw Chicken Breast
(10, 14, 100.0), -- Low-Fat Milk 1%
(15, 14, 50.0); -- Olive Oil

-- Meal 15: Snack - Greek Yogurt with Honey
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(12, 15, 100.0), -- Greek Yogurt (Plain)
(27, 15, 50.0); -- Honey

-- Meal 16: Brunch - Breakfast Burrito
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(2, 16, 100.0), -- Mission Foods Mission Flour Tortillas Soft Taco 8 Inch
(23, 16, 150.0), -- Raw Chicken Breast
(17, 16, 100.0), -- Crustaceans Shrimp Cooked (Not Previously Frozen)
(18, 16, 50.0); -- Lemon Juice From Concentrate Canned Or Bottled

-- Meal 17: Dinner - Spicy Tofu Stir Fry
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(7, 17, 150.0), -- Soft Tofu
(20, 17, 100.0), -- Avocados
(6, 17, 100.0), -- Soy Sauce
(30, 17, 50.0); -- Baked Russet Potatoes

-- Meal 18: Lunch - Chicken Caesar Wrap
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(2, 18, 100.0), -- Mission Foods Mission Flour Tortillas Soft Taco 8 Inch
(23, 18, 150.0), -- Raw Chicken Breast
(17, 18, 100.0), -- Crustaceans Shrimp Cooked (Not Previously Frozen)
(18, 18, 50.0); -- Lemon Juice From Concentrate Canned Or Bottled

-- Meal 19: Breakfast - Fruit Smoothie
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(19, 19, 100.0), -- Strawberries
(29, 19, 50.0), -- Romaine Lettuce
(27, 19, 50.0); -- Honey

-- Meal 20: Dinner - Baked Salmon
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(23, 20, 200.0), -- Raw Chicken Breast
(15, 20, 50.0), -- Olive Oil
(26, 20, 50.0); -- Red Wine Vinegar

-- Meal 21: Snack - Cheese and Crackers
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(4, 21, 100.0), -- Wheat Bread
(9, 21, 50.0); -- Mozzarella Cheese (Non-Fat Or Fat Free)

-- Meal 22: Breakfast - Breakfast Bowl
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(19, 22, 100.0), -- Strawberries
(30, 22, 50.0), -- Baked Russet Potatoes
(27, 22, 50.0); -- Honey

-- Meal 23: Dinner - Vegetable Stir Fry
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(31, 23, 100.0), -- Spinach
(32, 23, 100.0), -- Red Bell Peppers (Cooked)
(33, 23, 100.0); -- Sauteed Green Bell Peppers

-- Meal 24: Lunch - Greek Salad
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(11, 24, 100.0), -- Nonfat Greek Yogurt
(19, 24, 50.0), -- Strawberries
(29, 24, 50.0); -- Romaine Lettuce

-- Meal 25: Breakfast - Bagel with Cream Cheese
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(4, 25, 100.0), -- Wheat Bread
(9, 25, 50.0), -- Mozzarella Cheese (Non-Fat Or Fat Free)
(27, 25, 50.0); -- Honey

-- Meal 26: Dinner - Chicken Teriyaki
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(21, 26, 100.0), -- White Rice
(23, 26, 200.0), -- Raw Chicken Breast
(6, 26, 100.0), -- Soy Sauce
(27, 26, 50.0); -- Honey

-- Meal 27: Snack - Ants on a Log
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(28, 27, 50.0), -- Cooked Lima Beans
(29, 27, 50.0), -- Romaine Lettuce
(19, 27, 50.0); -- Strawberries

-- Meal 28: Brunch - Breakfast Wrap
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(2, 28, 100.0), -- Mission Foods Mission Flour Tortillas Soft Taco 8 Inch
(13, 28, 100.0), -- Egg Whole Cooked Ns As To Cooking Method
(20, 28, 50.0); -- Avocados

-- Meal 29: Dinner - BBQ Chicken
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(21, 29, 100.0), -- White Rice
(23, 29, 200.0), -- Raw Chicken Breast
(6, 29, 100.0), -- Soy Sauce
(27, 29, 50.0); -- Honey

-- Meal 30: Snack - Caprese Skewers
INSERT INTO meal_ingredient (ingredient_id, meal_id, quantityRatioOfIngredient) VALUES
(19, 30, 50.0), -- Strawberries
(34, 30, 50.0), -- Tomato Sauce Canned No Salt Added
(9, 30, 50.0); -- Mozzarella Cheese (Non-Fat Or Fat Free)

