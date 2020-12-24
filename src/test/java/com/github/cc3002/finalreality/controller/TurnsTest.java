package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.weapon.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnsTest {
    public GameController controller;

    @Test
    void winningGameTest() throws InterruptedException {
        controller = new GameController();

        assertTrue(controller.isPreparingParty());

        controller.addKnight("Draug", 8, 6,
                new Sword("Steel sword", 12, 12));
        controller.addEngineer("Beck", 7, 4,
                new Axe("Steel axe", 12, 15));
        controller.addThief("Julian", 7, 4,
                new Knife("Steel knife", 12, 21));
        controller.addBlackMage("Merric", 7, 2,
                new Staff("ArcFire", 12, 24, 12),10);

        assertTrue(controller.isPartyReady());

        controller.addEnemy("Minion1", 5, 1, 1, 18);
        controller.addEnemy("Minion2", 5, 1, 1, 20);

        controller.addSword("Mercurius", 16, 15);
        controller.addAxe("Hauteclere", 16, 15);
        controller.addKnife("Kard", 16, 3);
        controller.addStaff("Starlight", 16, 8, 16);
        controller.addBow("Parthia", 16, 8);

        controller.startGame();

        Thread.sleep(2500);
        while ((controller.getAmountOfPlayerCharacters() > 0)
                & (controller.getAmountOfEnemies() > 0)) {

            assertTrue(controller.isPlayerTurn());
            controller.activePlayerCharEquips(0);
            controller.activePlayerCharAttacksEnemy(0);
            Thread.sleep(2500);
        }
        assertTrue(controller.isBattleWon());
//        Exception exception = assertThrows(AssertionError.class, () -> {
//            controller.
//        });
    }

    @Test
    void losingGameTest() throws InterruptedException {
        controller = new GameController();

        assertTrue(controller.isPreparingParty());

        controller.addKnight("Draug", 8, 6,
                new Sword("Iron sword", 2, 10));
        controller.addEngineer("Beck", 7, 4,
                new Axe("Iron axe", 2, 11));
        controller.addThief("Julian", 7, 4,
                new Knife("Iron knife", 2, 20));
        controller.addBlackMage("Merric", 7, 2,
                new Staff("Fire", 2, 21, 2),10);

        assertTrue(controller.isPartyReady());

        controller.addEnemy("Gharnef", 100, 4, 25, 15);
        controller.addEnemy("Medeus", 150, 6, 30, 16);

        controller.addSword("Bronze sword", 1, 15);
        controller.addAxe("Bronze axe", 1, 15);
        controller.addKnife("Bronze knife", 1, 3);
        controller.addStaff("Stick", 1, 8, 1);
        controller.addBow("Bronze bow", 1, 8);

        controller.startGame();

        Thread.sleep(2500);
        while ((controller.getAmountOfPlayerCharacters() > 0)
                & (controller.getAmountOfEnemies() > 0)) {

            assertTrue(controller.isPlayerTurn());
            controller.activePlayerCharEquips(0);
            controller.activePlayerCharAttacksEnemy(0);
            Thread.sleep(2500);
        }
        assertTrue(controller.isBattleLost());
    }
}
