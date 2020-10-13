package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.*;

import java.util.EnumMap;
import java.util.Map;

import com.github.cc3002.finalreality.model.weapon.Staff;
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
  private Map<CharacterClass, String> characterNames;

  private ICharacter testBlackMage;
  private ICharacter testKnight;
  private ICharacter testWhiteMage;
  private ICharacter testEngineer;
  private ICharacter testThief;

  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    characterNames = new EnumMap<>(CharacterClass.class);
    characterNames.put(CharacterClass.BLACK_MAGE, BLACK_MAGE_NAME);
    characterNames.put(CharacterClass.KNIGHT, KNIGHT_NAME);
    characterNames.put(CharacterClass.WHITE_MAGE, WHITE_MAGE_NAME);
    characterNames.put(CharacterClass.ENGINEER, ENGINEER_NAME);
    characterNames.put(CharacterClass.THIEF, THIEF_NAME);

    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, 7, 8, 9, 10);
    testKnight = new Knight(KNIGHT_NAME, turns, 7, 8, 9);
    testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 9, 10);
    testEngineer = new Engineer(ENGINEER_NAME, turns, 7, 8, 9);
    testThief = new Thief(THIEF_NAME, turns, 7, 8, 9);

    testCharacters.add(testBlackMage);
    testCharacters.add(testKnight);
    testCharacters.add(testWhiteMage);
    testCharacters.add(testEngineer);
    testCharacters.add(testThief);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", turns, 7, 8, 9, 10);
    CharacterClass characterClass;
    String characterName;

    // BlackMage
    characterClass = testBlackMage.getCharacterClass();
    characterName = characterNames.get(characterClass);
    checkConstruction(new BlackMage(characterName, turns, 7, 8, 9, 10),
            testBlackMage,
            new BlackMage("Test", turns, 7, 8, 9, 10),
            (characterClass == CharacterClass.THIEF) ?
              new BlackMage(characterName, turns, 7, 8, 9, 10) :
              new Thief(characterName, turns, 7, 8, 9));
    assertNotEquals(testBlackMage, enemy);

    // Knight
    characterClass = testKnight.getCharacterClass();
    characterName = characterNames.get(characterClass);
    checkConstruction(new Knight(characterName, turns, 7, 8, 9),
            testKnight,
            new Knight("Test", turns, 7, 8, 9),
            (characterClass == CharacterClass.THIEF) ?
                    new BlackMage(characterName, turns, 7, 8, 9, 10) :
                    new Thief(characterName, turns, 7, 8, 9));
    assertNotEquals(testKnight, enemy);

    // WhiteMage
    characterClass = testWhiteMage.getCharacterClass();
    characterName = characterNames.get(characterClass);
    checkConstruction(new WhiteMage(characterName, turns, 7, 8, 9, 10),
            testWhiteMage,
            new WhiteMage("Test", turns, 7, 8, 9, 10),
            (characterClass == CharacterClass.THIEF) ?
                    new BlackMage(characterName, turns, 7, 8, 9, 10) :
                    new Thief(characterName, turns, 7, 8, 9));
    assertNotEquals(testWhiteMage, enemy);

    // Engineer
    characterClass = testEngineer.getCharacterClass();
    characterName = characterNames.get(characterClass);
    checkConstruction(new Engineer(characterName, turns, 7, 8, 9),
            testEngineer,
            new Engineer("Test", turns, 7, 8, 9),
            (characterClass == CharacterClass.THIEF) ?
                    new BlackMage(characterName, turns, 7, 8, 9, 10) :
                    new Thief(characterName, turns, 7, 8, 9));
    assertNotEquals(testEngineer, enemy);

    // Thief
    characterClass = testThief.getCharacterClass();
    characterName = characterNames.get(characterClass);
    checkConstruction(new Thief(characterName, turns, 7, 8, 9),
            testThief,
            new Thief("Test", turns, 7, 8, 9),
            (characterClass == CharacterClass.THIEF) ?
                    new BlackMage(characterName, turns, 7, 8, 9, 10) :
                    new Thief(characterName, turns, 7, 8, 9));
    assertNotEquals(testThief, enemy);

  }

  @Test
  void equipWeaponTest() {
    assertNull(testBlackMage.getEquippedWeapon());
    testBlackMage.equip(testWeapon);
    assertEquals(testWeapon, testBlackMage.getEquippedWeapon());

    assertNull(testKnight.getEquippedWeapon());
    testKnight.equip(testWeapon);
    assertEquals(testWeapon, testKnight.getEquippedWeapon());

    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testWeapon);
    assertEquals(testWeapon, testWhiteMage.getEquippedWeapon());

    assertNull(testEngineer.getEquippedWeapon());
    testEngineer.equip(testWeapon);
    assertEquals(testWeapon, testEngineer.getEquippedWeapon());

    assertNull(testThief.getEquippedWeapon());
    testThief.equip(testWeapon);
    assertEquals(testWeapon, testThief.getEquippedWeapon());
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
