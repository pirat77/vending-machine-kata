package com.codecool.Storage;

import com.codecool.Model.Coin;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoinStorageTest {
    CoinStorage coinStorage;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        coinStorage = new CoinStorage();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        coinStorage = null;
    }

    @org.junit.jupiter.api.Test
    void addElement() {
        assertFalse(coinStorage.hasElement(Coin.FIVE));
        coinStorage.addElement(Coin.FIVE);
        assertTrue(coinStorage.hasElement(Coin.FIVE));
    }

    @org.junit.jupiter.api.Test
    void addMultipleElements(){
        coinStorage.addElement(Coin.FIVE);
        coinStorage.addElement(Coin.FIVE);
        assertTrue(coinStorage.hasElement(Coin.FIVE));
        assertTrue(coinStorage.hasElement(Coin.FIVE));
        assertFalse(coinStorage.hasElement(Coin.FIVE));
    }

    @org.junit.jupiter.api.Test
    void hasElement() {
        coinStorage.addElement(Coin.TENTH);
        assertFalse(coinStorage.hasElement(Coin.FIVE));
        assertTrue(coinStorage.hasElement(Coin.TENTH));
    }

    @org.junit.jupiter.api.Test
    void clearBuffer() {
        coinStorage.getBuffer().keySet();
        coinStorage.addElement(Coin.TENTH);
        coinStorage.hasElement(Coin.TENTH);
        assertTrue(coinStorage.getBuffer().keySet().contains(Coin.TENTH));
        coinStorage.clearBuffer();
        assertFalse(coinStorage.getBuffer().keySet().contains(Coin.TENTH));
    }

    @org.junit.jupiter.api.Test
    void removeElements() {
        coinStorage.addElement(Coin.FIVE);
        HashMap<Coin, Integer> coins = new HashMap<>();
        coins.put(Coin.FIVE, 1);
        coinStorage.removeElements(coins);
        assertFalse(coinStorage.hasElement(Coin.FIVE));
        assertFalse(coinStorage.removeElements(coins));
    }
}