package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    public IngredientType type;
    public Ingredient ingredient;

    final String expectedIngredientName = RandomStringUtils.randomAlphabetic(10);
    final float expectedIngredientPrice = (float) Math.random();

    @Before
    public void setUp() {
        int ingredientType = new Random().nextInt(IngredientType.values().length);

        if (ingredientType == 0)
            type = SAUCE;
        else
            type = FILLING;
        ingredient = new Ingredient(type, expectedIngredientName, expectedIngredientPrice);
    }

    @Test
    public void getCurrentIngredientCorrectType() {
        assertEquals("Тип ингредиента не совпадает", type, ingredient.getType());
    }

    @Test
    public void getCurrentIngredientCorrectName() {
        assertEquals("Имя ингредиента не совпадает", expectedIngredientName, ingredient.getName());
    }

    @Test
    public void getCurrentIngredientCorrectPrice() {
        assertEquals("Цена не совпадает", expectedIngredientPrice, ingredient.getPrice(), 0.01);
    }
}