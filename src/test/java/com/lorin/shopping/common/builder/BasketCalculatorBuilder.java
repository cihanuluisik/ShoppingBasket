package com.lorin.shopping.common.builder;


import com.lorin.shopping.calculator.BasketCalculator;
import com.lorin.shopping.domain.Item;

import java.util.ArrayList;
import java.util.List;

import static com.lorin.shopping.common.builder.PriceListBuilder.newPriceList;

public class BasketCalculatorBuilder {

    final private List<Item> itemsList = new ArrayList<>();

    public static BasketCalculatorBuilder newBasketCalculator() {
        return new BasketCalculatorBuilder();
    }

    public BasketCalculatorBuilder withItemPrice(Item item) {
        itemsList.add(item);
        return this;
    }

    public BasketCalculator build(){
        return new BasketCalculator(newPriceList(itemsList).build());
    }


}
