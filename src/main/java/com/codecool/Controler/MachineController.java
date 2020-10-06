package com.codecool.Controler;

import com.codecool.Model.Coin;
import com.codecool.Storage.CoinStorage;
import com.codecool.Storage.ProductStorage;

public final class MachineController {
    private CoinStorage ownCoins;
    private CoinStorage insertedCoins;
    private CoinStorage change;
    private ProductStorage productStorage;
    private static MachineController machineController;
    private float credit;

    public float getCredit() {
        return credit;
    }



    public static MachineController getInstance(){
        if (machineController == null) machineController = new MachineController();
        return machineController;
    }

    private MachineController(){
        ownCoins = new CoinStorage();
        insertedCoins = new CoinStorage();
        change = new CoinStorage();
        productStorage = new ProductStorage();
        credit = 0;
    }

    protected void reset(){
        credit = 0;
        ownCoins.clearBuffer();
        insertedCoins = new CoinStorage();
        change = new CoinStorage();
    }

    public boolean insertCoin(String insertedCoin){
        Coin coin;
        try {
            coin = Coin.valueOf(insertedCoin);
            insertedCoins.addElement(coin);
            credit+=coin.getAmmount();
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
