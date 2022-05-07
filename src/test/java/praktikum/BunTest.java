package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    final String expectedBunName = RandomStringUtils.randomAlphabetic(10);
    final float expectedBunPrice = (float) Math.random();
    Bun bun = new Bun(expectedBunName, expectedBunPrice);

    @Test
    public void getBunCurrentName() {
        String actualBunName = bun.getName();
        assertEquals("Имя не совпадает", expectedBunName, actualBunName);
    }

    @Test
    public void getBunCurrentPrice() {
        float actualBunPrice = bun.getPrice();
        assertEquals("Цена не совпадает", expectedBunPrice, actualBunPrice, 0.01);
    }
}
