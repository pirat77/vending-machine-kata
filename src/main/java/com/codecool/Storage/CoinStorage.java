package com.codecool.Storage;

import com.codecool.Model.Coin;
import java.util.HashMap;
import java.util.Map;

public class CoinStorage implements Storage<Coin> {
    private HashMap<Coin, Integer> coins;
    private HashMap<Coin, Integer> buffer;

    public Map<Coin, Integer> getBuffer() {
        return buffer;
    }

    private void setBuffer(HashMap<Coin, Integer> buffer) {
        this.buffer = buffer;
    }

    public HashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public CoinStorage(){
        this.coins = new HashMap<>();
        this.buffer = new HashMap<>();
    }

    @Override
    public boolean addElement(Coin element) {
        // in real word scenario should check if there is space for another coin of kind, nice to have
        int currentAmount = this.getCoins().getOrDefault(element, 0);
        this.getCoins().put(element, currentAmount+1);
        return true;
    }

    @Override
    public boolean hasElement(Coin element) {
        int currentBuffer = getBuffer().getOrDefault(element, 0);
        int currentAmount = getCoins().getOrDefault(element, 0);
        if (currentBuffer == 0 && currentAmount > 0){
            getBuffer().put(element, 1);
            return true;
        } else if (currentBuffer < currentAmount){
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
        if (!elements.keySet().stream().allMatch(k -> elements.get(k)<=getCoins().get(k))) return false;
        elements.keySet().forEach(k -> getCoins().put(k, getCoins().get(k)-elements.get(k)));
        return true;
    }

    public void addElements(Map<Coin, Integer> elements) {
        elements.keySet().stream().filter(k -> getCoins().containsKey(k)).forEach(k -> getCoins().put(k, getCoins().get(k)+elements.get(k)));
        elements.keySet().stream().filter(k -> !getCoins().containsKey(k)).forEach(k -> getCoins().put(k, elements.get(k)));
    }
}
