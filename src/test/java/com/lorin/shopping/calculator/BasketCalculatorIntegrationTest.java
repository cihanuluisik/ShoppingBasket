package com.lorin.shopping.calculator;

import com.lorin.shopping.common.BasketTestHelper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketCalculatorIntegrationTest {

    private final BasketCalculator basketCalculator = new BasketTestHelper().createDefaultTestBasket();

    @Test
    public void givenSingleItemShouldCalculateCorrectCost() throws Exception {
        assertThat(basketCalculator.calculate("Apple")).isEqualTo(35);
        assertThat(basketCalculator.calculate("Banana")).isEqualTo(20);
        assertThat(basketCalculator.calculate("Melon")).isEqualTo(50);
        assertThat(basketCalculator.calculate("Lime")).isEqualTo(15);
        assertThat(basketCalculator.calculate("Peach")).isEqualTo(20);
    }

    @Test
    public void givenTwoAppleShouldChargeTwoApple() throws Exception {
        assertThat(basketCalculator.calculate("Apple", "Apple")).isEqualTo(70);
    }

    @Test
    public void givenManyDifferentItemsShouldCalculateCorrectCost() throws Exception {
        assertThat(basketCalculator.calculate("Banana", "Apple","Peach","Peach")).isEqualTo(95);
    }


}


