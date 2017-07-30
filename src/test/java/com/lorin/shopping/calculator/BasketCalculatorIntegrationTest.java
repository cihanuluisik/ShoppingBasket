package com.lorin.shopping.calculator;

import com.lorin.shopping.common.BasketTestHelper;
import com.lorin.shopping.domain.Basket;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketCalculatorIntegrationTest {

    private final BasketCalculator basketCalculator = new BasketTestHelper().createDefaultTestBasket();

    @Test
    public void givenSingleItemShouldCalculateCorrectCost() throws Exception {
        assertThat(basketCalculator.calculate(new Basket("Apple"))).isEqualTo(35);
        assertThat(basketCalculator.calculate(new Basket("Banana"))).isEqualTo(20);
        assertThat(basketCalculator.calculate(new Basket("Melon"))).isEqualTo(50);
        assertThat(basketCalculator.calculate(new Basket("Lime"))).isEqualTo(15);
        assertThat(basketCalculator.calculate(new Basket("Peach"))).isEqualTo(20);
    }

    @Test
    public void givenTwoAppleShouldChargeTwoApple() throws Exception {
        assertThat(basketCalculator.calculate(new Basket("Apple", "Apple"))).isEqualTo(70);
    }

    @Test
    public void givenManyDifferentItemsShouldCalculateCorrectCost() throws Exception {
        assertThat(basketCalculator.calculate(new Basket("Banana", "Apple","Peach","Peach"))).isEqualTo(95);
    }


}


