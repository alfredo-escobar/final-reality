package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.cc3002.finalreality.model.character.player.AbstractMage;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Enemy extends AbstractCharacter {

  private final int weight;

  /**
   * Creates a new enemy with a weapon equipped.
   *
   * @param name
   *     the enemy's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param health
   *     the enemy's health points
   * @param strength
   *     the enemy's strength
   * @param defense
   *     the enemy's defense
   * @param equippedWeapon
   *     the enemy's equipped weapon
   * @param weight
   *     the enemy's weight
   */
  public Enemy(@NotNull final String name,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               int health, int strength, int defense,
               final Weapon equippedWeapon,
               final int weight) {
    super(name, turnsQueue, CharacterClass.ENEMY, health, strength, defense, equippedWeapon);
    this.weight = weight;
  }

  /**
   * Creates a new enemy without a weapon equipped.
   *
   * @param name
   *     the enemy's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param health
   *     the enemy's health points
   * @param strength
   *     the enemy's strength
   * @param defense
   *     the enemy's defense
   * @param weight
   *     the enemy's weight
   */
  public Enemy(@NotNull final String name,
               @NotNull final BlockingQueue<ICharacter> turnsQueue,
               int health, int strength, int defense,
               final int weight) {
    super(name, turnsQueue, CharacterClass.ENEMY, health, strength, defense, null);
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void equip(Weapon weapon) { System.out.println("Can't equip weapon to enemy"); }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy that = (Enemy) o;
    return getName().equals(that.getName())
            && getHealth() == that.getHealth()
            && getStrength() == that.getStrength()
            && getDefense() == that.getDefense()
            && getWeight() == that.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass(), getName(),
            getHealth(), getStrength(), getDefense(),
            getWeight());
  }
}
