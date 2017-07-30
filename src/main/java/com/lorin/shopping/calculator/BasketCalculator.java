package com.lorin.shopping.calculator;

import com.lorin.shopping.domain.PriceList;
import com.lorin.shopping.validator.BasketValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public long calculate(String... basket) {

        basketValidator.validateBasket(basket);

        long totalCost = calculateTotal(basket);

        return totalCost;
    }

    private int calculateTotal(String[] basket) {
        return Arrays.stream(basket).mapToInt(priceList::getItemPrice).sum();
    }

}
