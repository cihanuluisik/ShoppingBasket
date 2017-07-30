package com.lorin.shopping.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.lorin.shopping.common.builder.ItemPriceBuilder.newItemPrice;
import static com.lorin.shopping.common.builder.PriceListBuilder.newPriceList;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceListUnitTest {

    @Test
    public void givenEmptyItemPricesConstructionThrowsIllegalArgument() throws Exception {
        assertThat(Assertions.catchThrowable(()-> new PriceList(null))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("Item prices can not be empty");
        assertThat(Assertions.catchThrowable(()-> new PriceList(new ArrayList<>()))).isInstanceOf(IllegalArgumentException.class)
                                                                        .hasMessage("Item prices can not be empty");
    }

    @Test
    public void givenSecondItemNullShouldThrowRuntime() throws Exception {
        ;
        assertThat(Assertions.catchThrowable(()-> new PriceList(Arrays.asList(new ItemPrice("Apple", 10)
                                                    ,(ItemPrice) null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item prices can not be empty");
    }

    @Test
    public void givenTheSameItemRepeatingThenTheLastItemPriceOverridesPrecedings() throws Exception {
        PriceList priceList = newPriceList(asList(newItemPrice("Apple").withPrice(10).build()
                                                , newItemPrice("APple").withPrice(2000).build())).build();
        assertThat(priceList.itemPriceCount()).isEqualTo(1);
        assertThat(priceList.getItemPrice("Apple")).isEqualTo(2000);
    }


}
