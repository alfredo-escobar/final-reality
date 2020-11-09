package com.github.cc3002.finalreality.model.weapon;

/**
 *  This represents a weapon from the game.
 *
 * @author Ignacio Slater Muñoz.
 */
public interface IWeapon {

  /**
   * Returns this weapon's name.
   */
  String getName();

  /**
   * Returns this weapon's damage points.
   */
  int getDamage();

  /**
   * Returns this weapon's weight.
   */
  int getWeight();

  /**
   * Returns true if a knight can equip this weapon,
   * returns false otherwise.
   */
  boolean canKnightEquip();

  /**
   * Returns true if an engineer can equip this weapon,
   * returns false otherwise.
   */
  boolean canEngineerEquip();

  /**
   * Returns true if a thief can equip this weapon,
   * returns false otherwise.
   */
  boolean canThiefEquip();

  /**
   * Returns true if a black mage can equip this weapon,
   * returns false otherwise.
   */
  boolean canBlackMageEquip();

  /**
   * Returns true if a white mage can equip this weapon,
   * returns false otherwise.
   */
  boolean canWhiteMageEquip();

  /**
   * Returns true if any player character can equip this weapon,
   * returns false otherwise.
   */
  boolean canAnyCharacterEquip();
}
