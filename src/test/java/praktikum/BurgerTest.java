package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    IngredientType expectedType = SAUCE;
    String expectedNameIngredient = "hot sauce";
    String expectedBunName = RandomStringUtils.randomAlphabetic(10);
    float expectedPriceBurger = (float) Math.random();

    @Test
    public void checkNameBun() {
        burger.setBuns(bun);
        assertEquals("Неправильное название булочки", bun.getName(), burger.bun.getName());
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals("Нет ингредиента", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredient() {
        int lengthBurgerWithoutIngredient = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент есть", lengthBurgerWithoutIngredient, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient() {
        Ingredient anotherIngredient =
                new Ingredient(ingredient.getType(), ingredient.getName(), ingredient.getPrice());

        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиент не на своем месте", ingredient, burger.ingredients.get(1));
        assertEquals("Ингредиент не на своем месте", anotherIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getCorrectReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(expectedBunName);
        Mockito.when(ingredient.getType()).thenReturn(expectedType);
        Mockito.when(burger.getPrice()).thenReturn(expectedPriceBurger);
        burger.addIngredient(ingredient);

        assertNotSame("Чек не содержит булочек", burger.getReceipt(),
                containsString(format("(==== %s ====)%n", expectedBunName)));
        assertNotSame("Чек не содержит ингредиента", burger.getReceipt(),
                containsString(format("= %s =%n", expectedNameIngredient)));
        assertNotSame("Чек не содержит цены", burger.getReceipt(),
                containsString(format("%nPrice: %f%n", expectedPriceBurger)));
    }
}
