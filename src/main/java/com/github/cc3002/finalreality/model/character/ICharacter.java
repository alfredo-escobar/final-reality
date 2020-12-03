package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.IEventHandler;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's health points.
   */
  int getHealth();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Gets this unit attacked
   * @param damage
   *     the damage points inflicted by the attacker.
   */
  void getAttacked(int damage);

  /**
   * Adds a handler to listen to this character's calls.
   * @param handler
   *     the handler that will listen to the calls.
   */
  void addListener(IEventHandler handler);
}
