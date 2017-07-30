package com.lorin.shopping.validator;

import com.lorin.shopping.domain.PriceList;

import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.Objects.isNull;

public class BasketValidator {

    private final PriceList priceList;

    public BasketValidator(PriceList priceList) {
        this.priceList = priceList;
    }

    public void validateBasket(String[] basket) {
        if ( isNull(basket)  ||  stream(basket).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Item can not be null!");
        }
        if ( stream(basket).anyMatch(priceList::doesNotContainsKey)) {
            throw new IllegalArgumentException("Unknown item!");
        }
    }

}
