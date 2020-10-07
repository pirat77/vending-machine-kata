package com.codecool.Controller;

import com.codecool.Model.Coin;
import com.codecool.Model.Product;
import com.codecool.Storage.CoinStorage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineControllerTest {
    MachineController machineController;

    @BeforeEach
    void setUp() {
        machineController = MachineController.getInstance();
    }

    @AfterEach
    void tearDown() {
        machineController.reset();
    }

    @Test
    void insertCoin() {
        assertFalse(machineController.insertCoin("Ziemniak"));
        assertTrue(machineController.insertCoin("FIVE"));
        assertEquals(5f, machineController.getCredit());
    }

    @Test
    void acceptMultipleCoins(){
        machineController.insertCoin("FIVE");
        machineController.insertCoin("QUARTER");
        assertEquals(5.25f, machineController.getCredit());
    }

    @Test
    void makeChangeTest(){
        machineController.insertCoin("FIVE");
        CoinStorage availableCoins = machineController.getOwnCoins();
        availableCoins.addElement(Coin.FIVE);
        availableCoins.addElement(Coin.TWO);
        availableCoins.addElement(Coin.TWO);
        availableCoins.addElement(Coin.ONE);
        availableCoins.addElement(Coin.HALF);
        availableCoins.addElement(Coin.HALF);
        availableCoins.addElement(Coin.QUARTER);
        availableCoins.addElement(Coin.QUARTER);
        availableCoins.addElement(Coin.TENTH);
        availableCoins.addElement(Coin.TENTH);
        assertTrue(machineController.makeChange(Product.candy));
    }

}