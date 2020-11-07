package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private ICharacter testEnemy;

  @BeforeEach
  void setUp() {
    basicSetUp();
    testEnemy = new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10);
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    testEnemy.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEnemy, turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, turns, 7, 8, 9, 10),
                      testEnemy,
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