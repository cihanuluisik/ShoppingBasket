package com.lorin.shopping.common.builder;


import com.lorin.shopping.calculator.BasketCalculator;
import com.lorin.shopping.domain.ItemPrice;

import java.util.ArrayList;
import java.util.List;

import static com.lorin.shopping.common.builder.PriceListBuilder.newPriceList;

public class BasketCalculatorBuilder {

    final private List<ItemPrice> itemsList = new ArrayList<>();

    public static BasketCalculatorBuilder newBasketCalculator() {
        return new BasketCalculatorBuilder();
    }

    public BasketCalculatorBuilder withItemPrice(ItemPrice itemPrice) {
        itemsList.add(itemPrice);
        return this;
    }

    public BasketCalculator build(){
        return new BasketCalculator(newPriceList(itemsList).build());
    }


}
