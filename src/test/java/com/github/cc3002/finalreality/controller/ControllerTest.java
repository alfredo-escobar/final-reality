package com.github.cc3002.finalreality.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
    public GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();

        controller.addKnight("Draug", 8, 2);
        controller.addWhiteMage("Lena", 7, 9, 10);
        controller.addEngineer("Jake", 7, 9);
        controller.addThief("Julian", 7, 9);

        controller.addEnemy("Gharnef", 8, 4, 7, 10);
        controller.addEnemy("Medeus", 10, 6, 9, 12);

        controller.addSword("Mercurius", 6, 10);
        controller.addAxe("Hauteclere", 6, 10);
        controller.addKnife("ButterKnife", 6, 10);
        controller.addStaff("Starlight", 6, 10, 7);
        controller.addBow("Parthia", 6, 10);
    }

    @Test
    void test() {
        assertEquals(8, controller.getEnemyHealth(0));
        controller.attackAnEnemy(0, 0);
        assertEquals(8, controller.getEnemyHealth(0));
        controller.equipToCharacter(0, 0);
        controller.attackAnEnemy(0, 0);
        assertEquals(6, controller.getEnemyHealth(0));
    }
}
