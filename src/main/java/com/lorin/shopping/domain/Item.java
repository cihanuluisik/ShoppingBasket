package com.lorin.shopping.domain;

public class Item {

    public String getName() {
        return name;
    }

    final private String  name;

    public Item(String name) {
        if ( name==null  || name.trim().length() ==0){
            throw new IllegalArgumentException("Item name can not be empty!");
        }
        this.name = name.toLowerCase();
    }
}
