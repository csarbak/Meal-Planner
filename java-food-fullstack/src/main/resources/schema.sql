
-- -----------------------------------------------------
-- Schema MealPlanner
-- -----------------------------------------------------
--DROP SCHEMA IF EXISTS `MealPlanner` ;

-- -----------------------------------------------------
-- Schema MealPlanner
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `MealPlanner` DEFAULT CHARACTER SET utf8 ;
--USE `MealPlanner` ;

-- -----------------------------------------------------
-- Table `MealPlanner`.`ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS ingredient ;

CREATE TABLE IF NOT EXISTS ingredient (
  ingredientId INT NOT NULL AUTO_INCREMENT,
  ingredientName VARCHAR(100) NOT NULL,
  caloriesPerGram DECIMAL(7,2) NOT NULL,
  proteinsPerGram DECIMAL(7,2) NOT NULL,
  fatsPerGram DECIMAL(7,2) NOT NULL,
  carbohydratesPerGram DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (ingredientId));


-- -----------------------------------------------------
-- Table `MealPlanner`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS user ;

CREATE TABLE IF NOT EXISTS user (
  userId INT NOT NULL AUTO_INCREMENT,
  userFName VARCHAR(100) NULL,
  userLName VARCHAR(100) NULL,
  PRIMARY KEY (userId));


-- -----------------------------------------------------
-- Table `MealPlanner`.`meal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS meal ;

CREATE TABLE IF NOT EXISTS meal (
  mealId INT NOT NULL AUTO_INCREMENT,
  mealName VARCHAR(100) NOT NULL,
  user_id INT NOT NULL,
  mealDesc MEDIUMTEXT NULL,
  PRIMARY KEY (mealId),
  CONSTRAINT fk_user_id
    FOREIGN KEY (user_id)
    REFERENCES user (userId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `MealPlanner`.`meal_ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS meal_ingredient ;

CREATE TABLE IF NOT EXISTS meal_ingredient (
  ingredient_id INT NOT NULL,
  meal_id INT NOT NULL,
  quantityRatioOfIngredient DECIMAL(10,3) NOT NULL,
  PRIMARY KEY (ingredient_id, meal_id),
  CONSTRAINT fk_ingredient_id
    FOREIGN KEY (ingredient_id)
    REFERENCES ingredient (ingredientId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_meal_id
    FOREIGN KEY (meal_id)
    REFERENCES meal (mealId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

