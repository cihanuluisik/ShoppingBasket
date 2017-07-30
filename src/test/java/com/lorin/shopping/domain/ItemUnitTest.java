package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemUnitTest {

    @Test
    public void givenEmptyItemNameItemConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new Item(null, 10))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item name can not be empty");
        assertThat(Assertions.catchThrowable(()-> new Item("", 10))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item name can not be empty");
        assertThat(Assertions.catchThrowable(()-> new Item(" ", 10))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item name can not be empty");
    }

    @Test
    public void givenNonPositiveItemPriceConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new Item("Apple", -10))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item price must be a positive value");
        assertThat(Assertions.catchThrowable(()-> new Item("Apple", 0))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item price must be a positive value");
    }

}
