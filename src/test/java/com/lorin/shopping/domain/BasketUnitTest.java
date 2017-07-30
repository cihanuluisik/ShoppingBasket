package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketUnitTest {


    @Test
    public void givenEmptyBasketConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new Basket(null))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Basket can not be empty!");
        assertThat(Assertions.catchThrowable(()-> new Basket(new String[]{}))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Basket can not be empty!");
    }

}
