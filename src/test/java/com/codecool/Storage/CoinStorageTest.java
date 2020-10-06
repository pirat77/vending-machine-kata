package com.codecool.Storage;

import com.codecool.Model.Coin;

import java.util.HashMap;

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
    void hasElement() {
        coinStorage.addElement(Coin.TENTH);
        assertFalse(coinStorage.hasElement(Coin.FIVE));
        assertTrue(coinStorage.hasElement(Coin.TENTH));
    }

    @org.junit.jupiter.api.Test
    void clearBuffer() {
    }

    @org.junit.jupiter.api.Test
    void removeElements() {
    }
}