package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, turns, 8, 9, 10, 11),
        new Thief(ENEMY_NAME, turns, 10, 9, 8));
  }

  @Test
  void EnemyEqualBranching() {
    var expectedEnemy = new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10);
    var differentNameEnemy = new Enemy("Nemesis", turns, 7, 8, 9, 10);
    var differentHealthEnemy = new Enemy(ENEMY_NAME, turns, 14, 8, 9, 10);
    var differentStrengthEnemy = new Enemy(ENEMY_NAME, turns, 7, 16, 9, 10);
    var differentDefenseEnemy = new Enemy(ENEMY_NAME, turns, 7, 8, 18, 10);
    var differentWeightEnemy = new Enemy(ENEMY_NAME, turns, 7, 8, 9, 20);
    var testKnight = new Knight("Jagen", turns, 5, 20, 18);

    assertEquals(expectedEnemy, expectedEnemy);
    assertNotEquals(testKnight, expectedEnemy);
    assertNotEquals(differentNameEnemy, expectedEnemy);
    assertNotEquals(differentHealthEnemy, expectedEnemy);
    assertNotEquals(differentStrengthEnemy, expectedEnemy);
    assertNotEquals(differentDefenseEnemy, expectedEnemy);
    assertNotEquals(differentWeightEnemy, expectedEnemy);
  }
}