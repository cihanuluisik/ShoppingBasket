package com.lorin.shopping.domain;

import java.util.Arrays;

public class Basket {

    private final Item[] items;

    public Basket(String... items) {
        if ( items == null || items.length ==0) {
            throw new IllegalArgumentException("Basket can not be empty!");
        }

        this.items = Arrays.stream(items).map( item -> new Item(item)).toArray(Item[]::new);
    }

    public Item[] getItems() {
        return items;
    }

}
