package com.lorin.shopping.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class PriceList {

    private final Map<String, Integer> priceMap = new HashMap<>();

    public PriceList(List<Item> itemPrices) {
        if ( itemPrices ==null || itemPrices.isEmpty()){
            throw new IllegalArgumentException("item prices can not be empty");
        }
        itemPrices.forEach(itemPrice -> priceMap.put(itemPrice.getName(), itemPrice.getPrice()));
    }

    public boolean doesNotContainsKey(String key) {
        return !priceMap.containsKey(key.toLowerCase());
    }

    public Integer getItemPrice(String key) {
        return priceMap.get(key.toLowerCase());
    }

    public int itemPriceCount() {
        return priceMap.entrySet().size();
    }

}
