package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Abstract class for creating test player characters, enemies and weapons.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class AbstractSetUp {

    protected static final String BLACK_MAGE_NAME = "Vivi";
    protected static final String KNIGHT_NAME = "Adelbert";
    protected static final String WHITE_MAGE_NAME = "Eiko";
    protected static final String ENGINEER_NAME = "Cid";
    protected static final String THIEF_NAME = "Zidane";

    protected static final String ENEMY_NAME = "Goblin";

    protected static final String AXE_NAME = "Test Axe";
    protected static final String STAFF_NAME = "Test Staff";
    protected static final String SWORD_NAME = "Test Sword";
    protected static final String BOW_NAME = "Test Bow";
    protected static final String KNIFE_NAME = "Test Knife";
    protected static final int DAMAGE = 15;
    protected static final int WEIGHT = 10;
    protected static final int MAGIC_DAMAGE = 12;
    protected static final int MAGIC_DAMAGE_2 = 15;

    protected ICharacter testBlackMage;
    protected ICharacter testKnight;
    protected ICharacter testWhiteMage;
    protected ICharacter testEngineer;
    protected ICharacter testThief;

    protected ICharacter testEnemy;

    protected IWeapon testAxe;
    protected IWeapon testStaff;
    protected IWeapon testSword;
    protected IWeapon testBow;
    protected IWeapon testKnife;

    protected BlockingQueue<ICharacter> turns;

    protected void setUpPlayerCharacters() {
        testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, 7, 9, 10);
        testKnight = new Knight(KNIGHT_NAME, turns, 7,  9);
        testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7,  9, 10);
        testEngineer = new Engineer(ENGINEER_NAME, turns, 7, 9);
        testThief = new Thief(THIEF_NAME, turns, 7, 9);
    }

    protected void setUpEnemy() {
        testEnemy = new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10);
    }

    protected void setUpWeapons() {
        testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
        testStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, MAGIC_DAMAGE);
        testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
        testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
        testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    }

    protected void setUpTurns() {
        turns = new LinkedBlockingQueue<>();
    }
}
