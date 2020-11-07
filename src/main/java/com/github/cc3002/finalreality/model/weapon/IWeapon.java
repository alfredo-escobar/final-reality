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
   * Returns this weapon's weight
   */
  int getWeight();
}
