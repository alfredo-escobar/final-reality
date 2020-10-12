package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, turns, 7, 8, 9, testWeapon, 10));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, turns, 7, 8, 9, testWeapon, 10),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, turns, 8, 9, 10, testWeapon, 11),
        new Thief(ENEMY_NAME, turns, 10, 9, 8, testWeapon));
  }
}