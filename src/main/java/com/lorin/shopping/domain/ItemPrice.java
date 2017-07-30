package com.lorin.shopping.domain;

public class ItemPrice {

    final private Item    item;
    final private Integer price;

    public ItemPrice(Item item, Integer price) {
        if ( item ==null ){
            throw new IllegalArgumentException("Item can not be empty");
        }
        if ( price <=0){
            throw new IllegalArgumentException("Item price must be a positive value");
        }
        this.item = item;
        this.price = price;
    }

    public ItemPrice(String item, int price) {
        this(new Item(item), price);
    }

    public String getName() {
        return item.getName();
    }

    public Integer getPrice() {
        return price;
    }

}
