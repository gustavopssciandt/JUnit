package org.acme.openapi.swaggerui;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FruitResourceTest {

    private FruitResource fruitResource;
    private List<Fruit> fruits = new ArrayList<>();

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

    @Nested
    @DisplayName("Given FruitResource is add")
    class FinFruitTest{

        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit = new Fruit();
        @BeforeEach
        public void beforeEach() {
            fruitResource = new FruitResource();
            fruit = new Fruit("Apple", "Winter fruit");
            fruits = fruitResource.find("Apple");
        }

        @Test
        @DisplayName("Then it should return the new element inside the fruit list")
        void shouldReturnElementInsideFruitList() {
            assertEquals(1, fruits.size());
            assertEquals("Apple", fruits.get(0).getName());
        }
    }

    @Nested
    @DisplayName("Given FruitResource is add")
    class ErrorFruitTest{

        @BeforeEach
        public void beforeEach() {
            fruitResource = new FruitResource();
        }

        @Test
        @DisplayName("Then it should return the new element inside the fruit list")
        void shouldReturnElementInsideFruitList() {
            assertThrows(RuntimeException.class, () -> {
                fruitResource.path("Maçã");
            });
        }
    }

}
