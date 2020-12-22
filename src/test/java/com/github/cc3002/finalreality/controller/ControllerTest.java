package com.github.cc3002.finalreality.controller;


import com.github.cc3002.finalreality.model.weapon.*;

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

        assert controller.isPreparingParty();
        assert !controller.isPartyReady();
        assert !controller.isBattleWon();
        assert !controller.isBattleLost();

        controller.addKnight("Draug", 8, 6,
                new Sword("Iron sword", 2, 2));
        controller.addWhiteMage("Wrys", 7, 2,
                new Staff("Fire", 2, 2, 2),10);
        controller.addEngineer("Beck", 7, 4,
                new Axe("Iron axe", 2, 2));
        controller.addThief("Julian", 7, 4,
                new Knife("Iron knife", 2, 2));

        // The following player characters won't get added to the party
        assert controller.isPartyReady();
        assert !controller.isPreparingParty();

        controller.addBlackMage("Merric", 7, 2,
                new Staff("Fire", 2, 2, 2), 10);
        controller.addKnight("Roger", 8, 6,
                new Sword("Iron sword", 2, 2));
        controller.addWhiteMage("Lena", 7, 2,
                new Staff("Fire", 2, 2, 2), 10);
        controller.addEngineer("Jake", 7, 4,
                new Axe("Iron axe", 2, 2));
        controller.addThief("Rickard", 7, 4,
                new Knife("Iron knife", 2, 2));

        controller.addEnemy("Gharnef", 10, 4, 7, 10);
        controller.addEnemy("Medeus", 15, 6, 30, 12);

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
        assertEquals("Gharnef", controller.getEnemyName(0));
        assertEquals(10, controller.getEnemyHealth(0));
        assertEquals(4, controller.getEnemyDefense(0));
        assertEquals(7, controller.getEnemyStrength(0));
        assertEquals(10, controller.getEnemyWeight(0));
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
    void KnightAttacksAllEnemies() {
        assertEquals(10, controller.getEnemyHealth(0));
        controller.attackAnEnemy(0, 0);
        assertEquals(10, controller.getEnemyHealth(0));
        controller.equipToCharacter(1, 0);
        controller.attackAnEnemy(0, 0);
        // Enemy 0 gets defeated.
        assertEquals(15, controller.getEnemyHealth(1));
        controller.attackAnEnemy(0, 1);
        assertEquals(5, controller.getEnemyHealth(1));
        controller.attackAnEnemy(0, 1);
        assert controller.isBattleWon();
    }

    @Test
    void EnemiesAttackAllPlayerCharacters() {
        assertEquals(8, controller.getPlayerCharacterHealth(0));
        controller.attackAPlayableCharacter(0, 0);
        assertEquals(7, controller.getPlayerCharacterHealth(0));
        controller.attackAPlayableCharacter(1, 0);
        // Player character 0 gets defeated.
        assertEquals(7, controller.getPlayerCharacterHealth(3));
        // Enemy 1 proceeds to defeat everyone.
        controller.attackAPlayableCharacter(1, 1);
        controller.attackAPlayableCharacter(1, 2);
        controller.attackAPlayableCharacter(1, 3);
        assert controller.isBattleLost();
    }

}
