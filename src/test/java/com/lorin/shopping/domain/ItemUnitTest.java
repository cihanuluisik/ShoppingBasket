package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemUnitTest {


    @Test
    public void givenEmptyItemNameItemConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new Item(null))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item name can not be empty!");
        assertThat(Assertions.catchThrowable(()-> new Item(""))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item name can not be empty!");
        assertThat(Assertions.catchThrowable(()-> new Item(" "))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item name can not be empty!");
    }

}
