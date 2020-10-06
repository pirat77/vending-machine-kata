package com.codecool.Model;

public enum Product {

    cola(1f),
    chips(0.5f),
    candy(0.65f);

    private final float amount;

    private Product(float amount){
        this.amount = amount;
    }

    public float getAmount(){
        return amount;
    }

}
