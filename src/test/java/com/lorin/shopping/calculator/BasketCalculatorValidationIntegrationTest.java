package com.lorin.shopping.calculator;

import com.lorin.shopping.common.BasketTestHelper;
import com.lorin.shopping.domain.Basket;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BasketCalculatorValidationIntegrationTest {

    private final BasketCalculator basketCalculator = new BasketTestHelper().createDefaultTestBasket();

    @Test
    public void givenEmptyOrNullPriceListBasketCalculatorConstructionFails() throws Exception {
        assertThat(catchThrowable( () -> new BasketCalculator(null))).isInstanceOf(IllegalArgumentException.class)
                                            .hasMessage("Some item price must be given");
    }

    @Test
    public void givenUnknownSingleItemShouldThrowRuntime() throws Exception {
        assertGivenBasketGivesGivenError("Unknown item!", "Berry");
    }

    @Test
    public void givenUnknownSecondItemShouldThrowRuntime() throws Exception {
        assertGivenBasketGivesGivenError("Unknown item!", "Apple", "Berry");
    }

    @Test
    public void givenItemNamesInRandomCapsShouldCalculateCorrect() throws Exception {
        assertThat(basketCalculator.calculate(new Basket("APPLE", "baNaNA", "melon","lIMe"))).isEqualTo(120);
    }

    private void assertGivenBasketGivesGivenError(String errorMessage, String... basket) {
        Assertions.assertThat(Assertions.catchThrowable(() -> basketCalculator.calculate(new Basket(basket))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}


