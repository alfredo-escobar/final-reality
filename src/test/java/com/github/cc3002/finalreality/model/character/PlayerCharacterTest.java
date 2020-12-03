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

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.setUpTurns();
    super.setUpPlayerCharacters();
    super.setUpEnemy();
    super.setUpWeapons();
  }

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    ((IPlayerCharacter)testEngineer).equip(testAxe);
    testEngineer.waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testEngineer, turns.peek());
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
  void equipBlackMageWeaponTest() {
    assertNull(((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter) testBlackMage).equip(testSword);
    assertNull(((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter) testBlackMage).equip(testAxe);
    assertNull(((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter) testBlackMage).equip(testBow);
    assertNull(((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter) testBlackMage).equip(testKnife);
    assertEquals(testKnife, ((IPlayerCharacter)testBlackMage).getEquippedWeapon());
    ((IPlayerCharacter) testBlackMage).equip(testStaff);
    assertEquals(testStaff, ((IPlayerCharacter)testBlackMage).getEquippedWeapon());
  }

  @Test
  void equipKnightWeaponTest() {
    assertNull(((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testStaff);
    assertNull(((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testBow);
    assertNull(((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testSword);
    assertEquals(testSword, ((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testAxe);
    assertEquals(testAxe, ((IPlayerCharacter)testKnight).getEquippedWeapon());
    ((IPlayerCharacter)testKnight).equip(testKnife);
    assertEquals(testKnife, ((IPlayerCharacter)testKnight).getEquippedWeapon());
  }

  @Test
  void equipWhiteMageWeaponTest() {
    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testSword);
    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testAxe);
    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testKnife);
    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testBow);
    assertNull(((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
    ((IPlayerCharacter)testWhiteMage).equip(testStaff);
    assertEquals(testStaff, ((IPlayerCharacter)testWhiteMage).getEquippedWeapon());
  }

  @Test
  void equipEngineerWeaponTest() {
    assertNull(((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testSword);
    assertNull(((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testKnife);
    assertNull(((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testStaff);
    assertNull(((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testAxe);
    assertEquals(testAxe, ((IPlayerCharacter)testEngineer).getEquippedWeapon());
    ((IPlayerCharacter)testEngineer).equip(testBow);
    assertEquals(testBow, ((IPlayerCharacter)testEngineer).getEquippedWeapon());
  }

  @Test
  void equipThiefWeaponTest() {
    assertNull(((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testAxe);
    assertNull(((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testStaff);
    assertNull(((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testSword);
    assertEquals(testSword, ((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testKnife);
    assertEquals(testKnife, ((IPlayerCharacter)testThief).getEquippedWeapon());
    ((IPlayerCharacter)testThief).equip(testBow);
    assertEquals(testBow, ((IPlayerCharacter)testThief).getEquippedWeapon());
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
    assertNotEquals(testAxe, testWhiteMage);
    assertNotEquals(testBlackMage, testWhiteMage);
    assertNotEquals(differentNameMage, testWhiteMage);
    assertNotEquals(differentHealthMage, testWhiteMage);
    assertNotEquals(differentStrengthMage, testWhiteMage);
    assertNotEquals(differentDefenseMage, testWhiteMage);
    assertNotEquals(differentManaMage, testWhiteMage);
  }
}
