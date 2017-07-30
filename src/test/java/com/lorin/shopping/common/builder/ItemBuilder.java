package com.lorin.shopping.common.builder;


import com.lorin.shopping.domain.Item;

public class ItemBuilder {

    private  String name=  "itemx";
    private Integer price = 0;

    public ItemBuilder(String name) {
        this.name = name;
    }

    public static ItemBuilder newItem(String name) {
        return new ItemBuilder(name);
    }

    public ItemBuilder withPrice(Integer price){
        this.price = price;
        return this;
    }

    public Item build(){
        return new Item(name, price);
    }

}
