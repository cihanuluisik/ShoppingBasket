package com.lorin.shopping.calculator;

import com.lorin.shopping.domain.Basket;
import com.lorin.shopping.domain.Item;
import com.lorin.shopping.domain.PriceList;
import com.lorin.shopping.validator.BasketValidator;

import java.util.Arrays;

public class BasketCalculator {

    private final PriceList priceList;
    private final BasketValidator basketValidator;

    public BasketCalculator(PriceList priceList) {
        if ( priceList==null || priceList.itemPriceCount() == 0  ) {
            throw new IllegalArgumentException("Some item price must be given");
        }
        this.priceList = priceList;
        this.basketValidator = new BasketValidator(priceList);
    }


    public long calculate(Basket basket) {

        basketValidator.validateBasket(basket);

        long totalCost = calculateTotal(basket);

        return totalCost;
    }


    private int calculateTotal(Basket basket) {
        return Arrays.stream(basket.getItems()).map(Item::getName).mapToInt(priceList::getItemPrice).sum();
    }

}
