package com.codecool.Model;

public enum Coin {
    FIVE(5f),
    TWO(2f),
    ONE(1f),
    HALF(0.5f),
    QUARTER(0.25f),
    TENTH(0.1f);

    private final float ammount;

    private Coin(float ammount){
        this.ammount = ammount;
    }

    public float getAmmount(){
        return ammount;
    }
}
