package com.codecool.Controller;

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

}