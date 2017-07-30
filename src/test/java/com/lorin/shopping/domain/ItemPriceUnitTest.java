package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemPriceUnitTest {

    @Test
    public void givenNullItemItemConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(() -> new ItemPrice((Item) null, 10))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item can not be empty");
    }

    @Test
    public void givenNonPositiveItemPriceConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new ItemPrice("Apple", -10))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item price must be a positive value");
        assertThat(Assertions.catchThrowable(()-> new ItemPrice("Apple", 0))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item price must be a positive value");
    }
}
