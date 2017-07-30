package com.lorin.shopping.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList {

    private final Map<String, Integer> priceMap = new HashMap<>();

    public PriceList(List<ItemPrice> itemPrices) {
        if ( itemPrices ==null || itemPrices.isEmpty() ||itemPrices.stream().anyMatch( itm -> itm == null) ){
            throw new IllegalArgumentException("Item prices can not be empty");
        }
        itemPrices.forEach(itemPrice -> priceMap.put(itemPrice.getName(), itemPrice.getPrice()));
    }

    public boolean doesNotContainKey(String key) {
        return !priceMap.containsKey(key.toLowerCase());
    }

    public Integer getItemPrice(String key) {
        return priceMap.get(key.toLowerCase());
    }

    public int itemPriceCount() {
        return priceMap.entrySet().size();
    }

}
