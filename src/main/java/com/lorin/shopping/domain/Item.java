package com.lorin.shopping.domain;

public class Item {

    final private String  name;
    final private Integer price;

    public Item(String name, Integer price) {
        if ( name ==null || name.trim().length()==0){
            throw new IllegalArgumentException("item name can not be empty");
        }
        if ( price <=0){
            throw new IllegalArgumentException("item price must be a positive value");
        }
        this.name = name.toLowerCase();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

}
