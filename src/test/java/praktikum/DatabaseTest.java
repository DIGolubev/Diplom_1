package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    int expectedCountBunsType = 3;
    int expectedCountIngredientType = 6;
    Database dataBase = new Database();

    @Test
    public void getCountBunsType() {
        assertEquals("Кол-во типов булочек в базе не совпадает с ожидаемым",
                expectedCountBunsType, dataBase.availableBuns().size());
    }

    @Test
    public void getCountIngredientType() {
        assertEquals("Кол-во типов ингредиентов в базе не совпадает с ожидаемым",
                expectedCountIngredientType, dataBase.availableIngredients().size());
    }
}
