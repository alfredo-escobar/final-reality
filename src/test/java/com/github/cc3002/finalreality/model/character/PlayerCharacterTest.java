package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
class PlayerCharacterTest extends AbstractCharacterTest {

  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private Map<CharacterClass, String> characterNames;

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

    testCharacters.add(new BlackMage(BLACK_MAGE_NAME, turns, 7, 8, 9, 10));
    testCharacters.add(new Knight(KNIGHT_NAME, turns, 7, 8, 9));
    testCharacters.add(new WhiteMage(WHITE_MAGE_NAME, turns, 7, 8, 9, 10));
    testCharacters.add(new Engineer(ENGINEER_NAME, turns, 7, 8, 9));
    testCharacters.add(new Thief(THIEF_NAME, turns, 7, 8, 9));
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {
    var enemy = new Enemy("Enemy", turns, 7, 8, 9, 10);

    // BlackMage
    character = testCharacters[0]
    var characterClass = character.getCharacterClass();
    var characterName = characterNames.get(characterClass);
    checkConstruction(new BlackMage(characterName, turns, 7, 8, 9, 10),
            character,
            new BlackMage("Test", turns, 7, 8, 9, 10),
            if (characterClass == CharacterClass.THIEF)
              new BlackMage(characterName, turns, 7, 8, 9, 10);
            else
              new Thief(characterName, turns, 7, 8, 9);
    assertNotEquals(character, enemy);

    // Knight
    character = testCharacters[1]
    var characterClass = character.getCharacterClass();
    var characterName = characterNames.get(characterClass);
    checkConstruction(new Knight(characterName, turns, 7, 8, 9),
            character,
            new Knight("Test", turns, 7, 8, 9),
    if (characterClass == CharacterClass.THIEF)
      new BlackMage(characterName, turns, 7, 8, 9, 10);
    else
      new Thief(characterName, turns, 7, 8, 9);
    assertNotEquals(character, enemy);

    // WhiteMage
    character = testCharacters[2]
    var characterClass = character.getCharacterClass();
    var characterName = characterNames.get(characterClass);
    checkConstruction(new WhiteMage(characterName, turns, 7, 8, 9, 10),
            character,
            new WhiteMage("Test", turns, 7, 8, 9, 10),
    if (characterClass == CharacterClass.THIEF)
      new BlackMage(characterName, turns, 7, 8, 9, 10);
    else
      new Thief(characterName, turns, 7, 8, 9);
    assertNotEquals(character, enemy);

    // Engineer
    character = testCharacters[3]
    var characterClass = character.getCharacterClass();
    var characterName = characterNames.get(characterClass);
    checkConstruction(new Engineer(characterName, turns, 7, 8, 9),
            character,
            new Engineer("Test", turns, 7, 8, 9),
    if (characterClass == CharacterClass.THIEF)
      new BlackMage(characterName, turns, 7, 8, 9, 10);
    else
      new Thief(characterName, turns, 7, 8, 9);
    assertNotEquals(character, enemy);

    // Thief
    character = testCharacters[4]
    var characterClass = character.getCharacterClass();
    var characterName = characterNames.get(characterClass);
    checkConstruction(new Thief(characterName, turns, 7, 8, 9),
            character,
            new Thief("Test", turns, 7, 8, 9),
    if (characterClass == CharacterClass.THIEF)
      new BlackMage(characterName, turns, 7, 8, 9, 10);
    else
      new Thief(characterName, turns, 7, 8, 9);
    assertNotEquals(character, enemy);

  }

  @Test
  void equipWeaponTest() {
    for (var character :
        testCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }
}
