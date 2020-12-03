package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.weapon.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnsTest {
    public GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();

        controller.addKnight("Draug", 8, 6,
                new Sword("Iron sword", 2, 10));
        controller.addEngineer("Beck", 7, 4,
                new Axe("Iron axe", 2, 20));
        controller.addThief("Julian", 7, 4,
                new Knife("Iron knife", 2, 30));
        controller.addBlackMage("Merric", 7, 2,
                new Staff("Fire", 2, 40, 2),10);

        controller.addEnemy("Gharnef", 10, 4, 7, 25);
        controller.addEnemy("Medeus", 15, 6, 30, 45);

        controller.addSword("Mercurius", 8, 10);
        controller.addAxe("Hauteclere", 16, 14);
        controller.addKnife("Kard", 5, 3);
        controller.addStaff("Starlight", 1, 8, 8);
        controller.addBow("Parthia", 7, 8);
    }

//    @Test
//    void waitTest() throws InterruptedException {
//        assertEquals(null, controller.getCurrentCharacter());
//        Thread.sleep(30000);
//        controller.startTurn();
//        assertEquals(controller.getPlayerCharacterName(0),
//                controller.getCurrentCharacter().getName());
//    }

    @Test
    void getPlayerCharacterInfo() {
        assertEquals("Merric", controller.getPlayerCharacterName(3));
        assertEquals(7, controller.getPlayerCharacterHealth(3));
        assertEquals(2, controller.getPlayerCharacterDefense(3));
        assertEquals(10, controller.getPlayerCharacterMana(3));
    }
}
