package com.lorin.shopping.common;

import com.lorin.shopping.calculator.BasketCalculator;

import static com.lorin.shopping.common.builder.BasketCalculatorBuilder.newBasketCalculator;
import static com.lorin.shopping.common.builder.ItemBuilder.newItem;

public class BasketTestHelper {

    public BasketCalculator createDefaultTestBasket() {
        return newBasketCalculator().withItemPrice(newItem("Apple").withPrice(35).build())
                .withItemPrice(newItem("Banana").withPrice(20).build())
                .withItemPrice(newItem("Melon").withPrice(50).build())
                .withItemPrice(newItem("Lime").withPrice(15).build())
                .withItemPrice(newItem("Peach").withPrice(20).build())
                .build();

    }

}
