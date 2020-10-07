package com.codecool.controller;

import com.codecool.Model.Coin;
import com.codecool.Model.Product;
import com.codecool.Storage.CoinStorage;
import com.codecool.Storage.ProductStorage;

public final class MachineController {
    private CoinStorage ownCoins;
    private CoinStorage insertedCoins;
    private CoinStorage change;
    private ProductStorage productStorage;
    private static MachineController machineController;
    private int credit;

    protected CoinStorage getOwnStorage(){
        return ownCoins;
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

    public float getCredit() {
        return credit;
    }

    public boolean insertCoin(String insertedCoin){
        Coin coin;
        try {
            coin = Coin.valueOf(insertedCoin);
            insertedCoins.addElement(coin);
            credit+=coin.getAmount();
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean makeChange(Product product){
        int toReturn = credit - product.getAmount();
        if (toReturn < 0) return false;
        for (Coin coin: Coin.values()){
            while (getOwnStorage().hasElement(coin) && toReturn>=coin.getAmount()) {
                change.addElement(coin);
                toReturn-=coin.getAmount();
            }
        }
        if (toReturn > 0){
            for (Coin coin: change.getCoins().keySet()){
                CoinStorage sideStorage = new CoinStorage();
                sideStorage.addElements(getOwnStorage().getCoins());
                sideStorage.removeElements(change.getCoins());
                CoinStorage sideChange = permutation(sideStorage, toReturn+coin.getAmount());
                if (sideChange != null) {
                    change.addElements(sideStorage.getCoins());
                    break;
                }
            }
        }
        if (toReturn != 0){
            reset();
            return false;
        } else {
            ownCoins.addElements(insertedCoins.getCoins());
            ownCoins.removeElements(change.getCoins());
            reset();
            return true;
        }
    }

    private CoinStorage permutation(CoinStorage sideStorage, int toReturn){
        CoinStorage sideChange = new CoinStorage();
        for (Coin coin: Coin.values()){
            while (sideStorage.hasElement(coin) && toReturn>=coin.getAmount()) {
                sideChange.addElement(coin);
                toReturn-=coin.getAmount();
            }
        }
        if (toReturn!=0) sideChange = null;
        return sideChange;
    }
}
