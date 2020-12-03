package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.AbstractSetUp;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the attacks between IPlayerCharacters and Enemy objects.
 *
 * @author Alfredo Escobar Urrea.
 */
class AttackTest extends AbstractSetUp {
    private int KnightHealth = 8;
    private int KnightDefense = 2;

    private int EnemyHealth = 8;
    private int EnemyStrength = 7;
    private int EnemyDefense = 4;

    private int SwordDamage = 9;

    @BeforeEach
    void setUp() {
        super.setUpTurns();
        testKnight = new Knight(KNIGHT_NAME, turns, KnightHealth, KnightDefense);
        testEnemy = new Enemy(ENEMY_NAME, turns, EnemyHealth, EnemyDefense, EnemyStrength, 10);
        testSword = new Sword(SWORD_NAME, SwordDamage, WEIGHT);
    }

    @Test
    void KnightAttacksEnemy() {
        assertEquals(testEnemy.getHealth(), EnemyHealth);
        ((IPlayerCharacter)testKnight).attack((Enemy)testEnemy); // Unsuccessful attack
        assertEquals(EnemyHealth, testEnemy.getHealth());

        ((IPlayerCharacter)testKnight).equip(testSword);
        ((IPlayerCharacter)testKnight).attack(((Enemy)testEnemy)); // 5 HP lost
        assertEquals(EnemyHealth - (SwordDamage-EnemyDefense), testEnemy.getHealth());

        ((IPlayerCharacter)testKnight).attack(((Enemy)testEnemy)); // Enemy defeated
        assertEquals(0, testEnemy.getHealth());
    }

    @Test
    void EnemyAttacksKnight() {
        assertEquals(KnightHealth, testKnight.getHealth());
        ((Enemy)testEnemy).attack((IPlayerCharacter)testKnight); // 5 HP lost
        assertEquals(KnightHealth - (EnemyStrength-KnightDefense), testKnight.getHealth());

        ((Enemy)testEnemy).attack((IPlayerCharacter)testKnight); // Knight defeated
        assertEquals(0, testKnight.getHealth());
    }
}
