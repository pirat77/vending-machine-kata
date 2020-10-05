package com.codecool.Storage;

import com.codecool.Model.Coin;
import java.util.HashMap;

public class CoinStorage implements Storage<Coin> {
    private HashMap<Coin, Integer> coins;
    private HashMap<Coin, Integer> buffer;

    public HashMap<Coin, Integer> getBuffer() {
        return buffer;
    }

    public void setBuffer(HashMap<Coin, Integer> buffer) {
        this.buffer = buffer;
    }

    private HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    private void setCoins(HashMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public CoinStorage(){
        this.coins = new HashMap<>();
        this.buffer = new HashMap<>();
    }

    public CoinStorage(HashMap<Coin, Integer> coins){
        setCoins(coins);
        this.buffer = new HashMap<>();
    }

    @Override
    public boolean addElement(Coin element) {
        if (this.getCoins().keySet().contains(element)){
            this.getCoins().put(element, this.getCoins().get(element)+1);
        } else {
            this.getCoins().put(element, 1);
        }
        return true;
    }

    @Override
    public boolean hasElement(Coin element) {
        int currentAmmount = getBuffer().get(element);
        if (currentAmmount == 0){
            getBuffer().put(element, 1);
            return true;
        } else if (currentAmmount < getCoins().get(element)){
            getBuffer().put(element, getBuffer().get(element)+1);
            return true;
        }
        return false;
    }

    @Override
    public boolean clearBuffer() {
        setBuffer(new HashMap<>());
        return true;
    }

    @Override
    public boolean removeElements(HashMap<Coin, Integer> elements) {
        if (!elements.keySet().stream().allMatch(k -> elements.get(k)<getCoins().get(k))) return false;
        elements.keySet().forEach(k -> getCoins().put(k, getCoins().get(k)-elements.get(k)));
        return true;
    }
}
