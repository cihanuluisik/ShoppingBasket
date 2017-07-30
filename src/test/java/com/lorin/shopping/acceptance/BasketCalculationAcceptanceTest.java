package com.lorin.shopping.acceptance;

import com.lorin.shopping.calculator.BasketCalculator;
import com.lorin.shopping.common.BasketTestHelper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketCalculationAcceptanceTest {

    private final BasketCalculator basketCalculator = new BasketTestHelper().createDefaultTestBasket();

    @Test
    public void supportMultiItemBasket() throws Exception {
        assertThat(basketCalculator.calculate("Apple", "Apple", "Banana", "Banana", "Lime", "Lime", "Peach")).isEqualTo(160);
    }


}
