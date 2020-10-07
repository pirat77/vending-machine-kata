package com.codecool.Model;

public enum Product {

    cola(100),
    chips(50),
    candy(65);

    private final float amount;

    private Product(float amount){
        this.amount = amount;
    }

    public float getAmount(){
        return amount;
    }

}
