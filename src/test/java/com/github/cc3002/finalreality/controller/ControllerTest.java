package com.github.cc3002.finalreality.controller;


import com.github.cc3002.finalreality.model.weapon.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
    public GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();

        assertTrue(controller.isPreparingParty());
        assertFalse(controller.isPartyReady());
        assertFalse(controller.isBattleWon());
        assertFalse(controller.isBattleLost());
        assertFalse(controller.isPlayerTurn());
        assertFalse(controller.isEnemyTurn());
        assertFalse(controller.isRemovingCharacterFromQueue());
        assertFalse(controller.isSelectingFirstInQueue());

        controller.addKnightWithSword("Draug",8, 6,
                "Iron sword", 2, 2);
        controller.addWhiteMageWithStaff("Wrys", 7, 2, 10,
                "Fire", 2, 20, 2);
        controller.addEngineerWithAxe("Beck", 7, 4,
                "Iron axe", 2, 22);
        controller.addThiefWithKnife("Julian", 7, 4,
                "Iron knife", 2, 24);
        
        assertTrue(controller.isPartyReady());
        assertFalse(controller.isPreparingParty());

        for (int i=0; i<10; i++) {
            // The first six bandits get added.
            controller.addEnemy("Bandit", 10, 4, 7, 26);
        }

        controller.addSword("Mercurius", 8, 10);
        controller.addAxe("Hauteclere", 16, 14);
        controller.addKnife("Kard", 5, 3);
        controller.addStaff("Starlight", 1, 8, 8);
        controller.addBow("Parthia", 7, 8);
    }

    @Test
    void getPlayerCharacterInfo() {
        assertEquals("Draug", controller.getPlayerCharacterName(0));
        assertEquals(8, controller.getPlayerCharacterHealth(0));
        assertEquals(6, controller.getPlayerCharacterDefense(0));
        assertEquals(10, controller.getPlayerCharacterMana(1));
    }

    @Test
    void getEnemyInfo() {
        assertEquals("Bandit", controller.getEnemyName(0));
        assertEquals(10, controller.getEnemyHealth(0));
        assertEquals(4, controller.getEnemyDefense(0));
        assertEquals(7, controller.getEnemyStrength(0));
        assertEquals(26, controller.getEnemyWeight(0));
    }

    @Test
    void getWeaponInfo() {
        assertEquals("Mercurius", controller.getWeaponName(0));
        assertEquals(8, controller.getWeaponDamage(0));
        assertEquals(10, controller.getWeaponWeight(0));
        assertEquals(8, controller.getWeaponMagicDamage(3));
    }

    @Test
    void equipTest() {
        controller.equipToCharacter(0, 0);
        assertEquals("Mercurius", controller.getPlayerCharacterWeapon(0).getName());
        controller.equipToCharacter(3, 0);
        // Knights can't equip bows
        assertEquals("Mercurius", controller.getPlayerCharacterWeapon(0).getName());
        controller.equipToCharacter(0, 0);
        // The sword Mercurius returns to the inventory
        assertEquals("Hauteclere", controller.getPlayerCharacterWeapon(0).getName());
        assertEquals("Mercurius", controller.getWeaponName(4));
    }

    @Test
    void getDataForGUI() throws InterruptedException {
        assertEquals("Knight.png", controller.getPlayerCharacterSprite(0));
        assertEquals("Enemy.png", controller.getEnemySprite(0));
        assertEquals(5, controller.getAmountOfWeapons());
        controller.startGame();
        Thread.sleep(1000);
        assertEquals("Draug", controller.getActivePlayerCharName());
        assertEquals("Iron sword (Damage: 2)", controller.getActivePlayerCharWeaponData());
    }
}
