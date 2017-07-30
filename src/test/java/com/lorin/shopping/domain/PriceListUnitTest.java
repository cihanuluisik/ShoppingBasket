package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

import static com.lorin.shopping.common.builder.ItemBuilder.newItem;
import static com.lorin.shopping.common.builder.PriceListBuilder.newPriceList;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceListUnitTest {

    @Test
    public void givenEmptyItemPricesConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new PriceList(null))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item prices can not be empty");
        assertThat(Assertions.catchThrowable(()-> new PriceList(new ArrayList<>()))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("item prices can not be empty");
    }


    @Test
    public void givenTheSameItemRepeatingThenTheLastItemPriceOverridesPrecedings() throws Exception {
        PriceList priceList = newPriceList(asList(newItem("Apple").withPrice(10).build()
                                                , newItem("APple").withPrice(2000).build())).build();
        assertThat(priceList.itemPriceCount()).isEqualTo(1);
        assertThat(priceList.getItemPrice("Apple")).isEqualTo(2000);
    }


}
