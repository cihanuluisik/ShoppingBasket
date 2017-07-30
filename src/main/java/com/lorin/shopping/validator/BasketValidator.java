package com.lorin.shopping.validator;

import com.lorin.shopping.domain.Basket;
import com.lorin.shopping.domain.Item;
import com.lorin.shopping.domain.PriceList;

import static java.util.Arrays.stream;

public class BasketValidator {

    private final PriceList priceList;

    public BasketValidator(PriceList priceList) {
        this.priceList = priceList;
    }

    public void validateBasket(Basket basket) {
        if ( stream(basket.getItems()).map(Item::getName).anyMatch(priceList::doesNotContainKey)) {
            throw new IllegalArgumentException("Unknown item!");
        }
    }

}
