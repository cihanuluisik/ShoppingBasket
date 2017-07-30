package com.lorin.shopping.common.builder;


import com.lorin.shopping.domain.Item;
import com.lorin.shopping.domain.ItemPrice;

public class ItemPriceBuilder {

    private  String name=  "itemx";
    private Integer price = 0;

    public ItemPriceBuilder(String name) {
        this.name = name;
    }

    public static ItemPriceBuilder newItemPrice(String name) {
        return new ItemPriceBuilder(name);
    }

    public ItemPriceBuilder withPrice(Integer price){
        this.price = price;
        return this;
    }

    public ItemPrice build(){
        return new ItemPrice(new Item(name), price);
    }

}
