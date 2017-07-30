package com.lorin.shopping.common.builder;

import com.lorin.shopping.domain.Item;
import com.lorin.shopping.domain.PriceList;

import java.util.ArrayList;
import java.util.List;

public class PriceListBuilder {

    final private List<Item> itemsList = new ArrayList<>();

    public PriceListBuilder(List<Item> itemsList) {
        this.itemsList.addAll(itemsList);
    }
    public PriceListBuilder() {
    }

    public static PriceListBuilder newPriceList() {
        return new PriceListBuilder();
    }

    public static PriceListBuilder newPriceList(List<Item> itemsList) {
        return new PriceListBuilder(itemsList);
    }

    public PriceList build(){
        return new PriceList(itemsList);
    }
}
