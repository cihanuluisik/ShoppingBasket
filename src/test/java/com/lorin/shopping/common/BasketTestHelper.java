package com.lorin.shopping.common;

import com.lorin.shopping.calculator.BasketCalculator;

import static com.lorin.shopping.common.builder.BasketCalculatorBuilder.newBasketCalculator;
import static com.lorin.shopping.common.builder.ItemPriceBuilder.newItemPrice;

public class BasketTestHelper {

    public BasketCalculator createDefaultTestBasket() {
        return newBasketCalculator().withItemPrice(newItemPrice("Apple").withPrice(35).build())
                .withItemPrice(newItemPrice("Banana").withPrice(20).build())
                .withItemPrice(newItemPrice("Melon").withPrice(50).build())
                .withItemPrice(newItemPrice("Lime").withPrice(15).build())
                .withItemPrice(newItemPrice("Peach").withPrice(20).build())
                .build();
    }

}
