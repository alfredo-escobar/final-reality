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

        controller.addKnightWithKnife("Draug", 8, 6,
                "Steel knife", 12, 12);
        controller.addEngineerWithBow("Beck", 7, 4,
                "Steel bow", 12, 15);
        controller.addThiefWithBow("Julian", 7, 4,
                "Steel bow", 12, 21);
        controller.addBlackMageWithKnife("Merric", 7, 2, 10,
                "Steel knife", 12, 24);

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

        controller.addKnightWithAxe("Draug", 8, 6,
                "Iron axe", 2, 5);
        controller.addEngineerWithBow("Beck", 7, 4,
                "Iron bow", 2, 6);
        controller.addThiefWithSword("Julian", 7, 4,
                "Iron sword", 2, 15);
        controller.addBlackMageWithStaff("Merric", 7, 2, 10,
                "Fire", 2, 16, 2);

        assertTrue(controller.isPartyReady());

        controller.addEnemy("Gharnef", 100, 4, 25, 10);
        controller.addEnemy("Medeus", 150, 6, 30, 11);

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
