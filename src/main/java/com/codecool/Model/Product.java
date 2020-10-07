package com.codecool.Model;

public enum Product {

    cola(100),
    chips(50),
    candy(65);

    private final int amount;

    private Product(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

}
