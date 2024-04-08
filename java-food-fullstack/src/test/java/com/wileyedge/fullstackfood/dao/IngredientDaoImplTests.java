package com.wileyedge.fullstackfood.dao;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@DataJdbcTest
public class IngredientDaoImplTests {
    private JdbcTemplate jdbcTemplate;
    private IngredientDao ingredientDao;


}
