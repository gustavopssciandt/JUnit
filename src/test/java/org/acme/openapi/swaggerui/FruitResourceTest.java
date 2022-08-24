package org.acme.openapi.swaggerui;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FruitResourceTest {

    private FruitResource fruitResource;
    private Set<Fruit> fruits = new HashSet<>();

    @Nested
    @DisplayName("Given FruitResource is called")
    class CalledFruitTest{

        @BeforeEach
        public void beforeEach() {
            fruitResource = new FruitResource();
            fruits = fruitResource.list();
        }

        @Test
        @DisplayName("Then it should return a list of fruits")
        void shouldReturnListWithFruits() {
            assertNotNull(fruits);
        }
    }

    @Nested
    @DisplayName("Given FruitResource is add")
    class AddFruitTest{

        private Fruit fruit;

        @BeforeEach
        public void beforeEach() {
            fruitResource = new FruitResource();
            fruit = new Fruit("Apple", "Winter fruit");
            fruits = fruitResource.add(fruit);
        }

        @Test
        @DisplayName("Then it should return the new element inside the fruit list")
        void shouldReturnElementInsideFruitList() {
            assertEquals(true, fruits.contains(fruit));
        }

    }



}
