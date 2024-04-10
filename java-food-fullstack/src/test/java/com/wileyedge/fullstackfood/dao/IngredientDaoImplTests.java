package com.wileyedge.fullstackfood.dao;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest //This makes each test transactional, so changes to the db get rolled back after each test
public class IngredientDaoImplTests {
    private JdbcTemplate jdbcTemplate;
    private IngredientDao ingredientDao;


}
