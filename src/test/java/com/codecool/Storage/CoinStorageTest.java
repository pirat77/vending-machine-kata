package com.codecool.Storage;

import com.codecool.Model.Coin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CoinStorageTest {
    CoinStorage coinStorage;

    @BeforeEach
    void setUp() {
        coinStorage = new CoinStorage();
    }

    @AfterEach
    void tearDow() {
        coinStorage = null;
    }

    @Test
    void addElement() {
        boolean oldState = coinStorage.hasElement(Coin.FIVE);
        coinStorage.addElement(Coin.FIVE);
        boolean newState = coinStorage.hasElement(Coin.FIVE);
        assertAll(
                () -> assertFalse(oldState),
                () -> assertTrue(newState)
        );
    }

    @Test
    void addMultipleElements(){
        coinStorage.addElement(Coin.FIVE);
        coinStorage.addElement(Coin.FIVE);
        assertAll(
                () -> assertTrue(coinStorage.hasElement(Coin.FIVE)),
                () -> assertTrue(coinStorage.hasElement(Coin.FIVE)),
                () -> assertFalse(coinStorage.hasElement(Coin.FIVE))
        );
    }

    @Test
    void hasElement() {
        coinStorage.addElement(Coin.TENTH);
        assertAll(
                () -> assertFalse(coinStorage.hasElement(Coin.FIVE)),
                () -> assertTrue(coinStorage.hasElement(Coin.TENTH))
        );
    }

    @Test
    void clearBuffer() {
        coinStorage.addElement(Coin.TENTH);
        coinStorage.hasElement(Coin.TENTH);
        assertTrue(coinStorage.getBuffer().containsKey(Coin.TENTH));
        coinStorage.clearBuffer();
        assertFalse(coinStorage.getBuffer().containsKey(Coin.TENTH));
    }

    @Test
    void removeElements() {
        coinStorage.addElement(Coin.FIVE);
        HashMap<Coin, Integer> coins = new HashMap<>();
        coins.put(Coin.FIVE, 1);
        coinStorage.removeElements(coins);
        assertFalse(coinStorage.hasElement(Coin.FIVE));
        assertFalse(coinStorage.removeElements(coins));
    }
}