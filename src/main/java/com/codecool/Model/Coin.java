package com.codecool.Model;

public enum Coin {
    FIVE(500),
    TWO(200),
    ONE(100),
    HALF(50),
    QUARTER(25),
    TENTH(10);

    private final float amount;

    private Coin(float amount){
        this.amount = amount;
    }

    public float getAmount(){
        return amount;
    }
}
