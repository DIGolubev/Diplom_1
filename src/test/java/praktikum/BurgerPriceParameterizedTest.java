package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest {
    Burger burger = new Burger();
    float expectedBurgerPrice;
    float expectedBunPrice;
    float expectedIngredientPrice;

    public BurgerPriceParameterizedTest(float expectedBunPrice, float ingredientPrice, float expectedBurgerPrice) {
        this.expectedBunPrice = expectedBunPrice;
        this.expectedIngredientPrice = ingredientPrice;
        this.expectedBurgerPrice = expectedBurgerPrice;
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Parameterized.Parameters
    public static Object[][] Test() {
        return new Object[][]{
                {5.50f, 5.50f, 16.50f},
                {1.14f, 0f, 2.28f},
                {0f, 0f, 0f},
        };
    }

    @Test
    public void getCorrectPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(expectedBunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn((expectedIngredientPrice));

        assertEquals("Цена рассчитана неправильно", expectedBurgerPrice, burger.getPrice(), 0.01);
    }
}

