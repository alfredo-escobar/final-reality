package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";

  private ICharacter testBlackMage;
  private ICharacter testKnight;
  private ICharacter testWhiteMage;
  private ICharacter testEngineer;
  private ICharacter testThief;
  private ICharacter testEnemy;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, 7, 8, 9, 10);
    testKnight = new Knight(KNIGHT_NAME, turns, 7, 8, 9);
    testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 9, 10);
    testEngineer = new Engineer(ENGINEER_NAME, turns, 7, 8, 9);
    testThief = new Thief(THIEF_NAME, turns, 7, 8, 9);
    testEnemy = new Enemy("Enemy", turns, 7, 8, 9, 10);

    testCharacters.add(testBlackMage);
    testCharacters.add(testKnight);
    testCharacters.add(testWhiteMage);
    testCharacters.add(testEngineer);
    testCharacters.add(testThief);
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip((PlayerCharacter)testCharacters.get(0));
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void BlackMageConstructorTest() {
    checkConstruction(new BlackMage(BLACK_MAGE_NAME, turns, 7, 8, 9, 10),
                      testBlackMage,
                      new BlackMage("Test", turns, 7, 8, 9, 10),
                      new Thief(BLACK_MAGE_NAME, turns, 7, 8, 9));
    assertNotEquals(testBlackMage, testEnemy);
  }

  @Test
  void KnightConstructorTest() {
    checkConstruction(new Knight(KNIGHT_NAME, turns, 7, 8, 9),
                      testKnight,
                      new Knight("Test", turns, 7, 8, 9),
                      new Thief(KNIGHT_NAME, turns, 7, 8, 9));
    assertNotEquals(testKnight, testEnemy);
  }

  @Test
  void WhiteMageConstructorTest() {
    checkConstruction(new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 9, 10),
                      testWhiteMage,
                      new WhiteMage("Test", turns, 7, 8, 9, 10),
                      new Thief(WHITE_MAGE_NAME, turns, 7, 8, 9));
    assertNotEquals(testWhiteMage, testEnemy);
  }

  @Test
  void EngineerConstructorTest() {
    checkConstruction(new Engineer(ENGINEER_NAME, turns, 7, 8, 9),
                      testEngineer,
                      new Engineer("Test", turns, 7, 8, 9),
                      new Thief(ENGINEER_NAME, turns, 7, 8, 9));
    assertNotEquals(testEngineer, testEnemy);
  }

  @Test
  void ThiefConstructorTest() {
    checkConstruction(new Thief(THIEF_NAME, turns, 7, 8, 9),
                      testThief,
                      new Thief("Test", turns, 7, 8, 9),
                      new BlackMage(THIEF_NAME, turns, 7, 8, 9, 10));
    assertNotEquals(testThief, testEnemy);
  }

  @Test
  void equipWeaponTest() {
    assertNull(((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter)testBlackMage).equip(testWeapon);
    assertEquals(testWeapon, ((IPlayerCharacter)testBlackMage).getEquippedWeapon());

    assertNull(((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testWeapon);
    assertEquals(testWeapon, ((IPlayerCharacter)testKnight).getEquippedWeapon());

    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testWeapon);
    assertEquals(testWeapon, ((IPlayerCharacter)testWhiteMage).getEquippedWeapon());

    assertNull(((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testWeapon);
    assertEquals(testWeapon, ((IPlayerCharacter)testEngineer).getEquippedWeapon());

    assertNull(((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testWeapon);
    assertEquals(testWeapon, ((IPlayerCharacter)testThief).getEquippedWeapon());
  }

  @Test
  void manaTest() {
    int testMana = 12;
    BlackMage testBlackMage2 = new BlackMage(BLACK_MAGE_NAME, turns, 7, 8, 9, testMana);
    assertEquals(testMana, testBlackMage2.getMana());
    WhiteMage testWhiteMage2 = new WhiteMage(BLACK_MAGE_NAME, turns, 7, 8, 9, testMana);
    assertEquals(testMana, testWhiteMage2.getMana());
  }

  @Test
  void MageEqualBranching() {
    var differentNameMage = new WhiteMage("Merric", turns, 7, 8, 9, 10);
    var differentHealthMage = new WhiteMage(WHITE_MAGE_NAME, turns, 10, 8, 9, 10);
    var differentStrengthMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7, 11, 9, 10);
    var differentDefenseMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 12, 10);
    var differentManaMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 9, 13);

    assertEquals(testWhiteMage, testWhiteMage);
    assertNotEquals(testWeapon, testWhiteMage);
    assertNotEquals(testBlackMage, testWhiteMage);
    assertNotEquals(differentNameMage, testWhiteMage);
    assertNotEquals(differentHealthMage, testWhiteMage);
    assertNotEquals(differentStrengthMage, testWhiteMage);
    assertNotEquals(differentDefenseMage, testWhiteMage);
    assertNotEquals(differentManaMage, testWhiteMage);
  }
}
