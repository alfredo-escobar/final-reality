package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Enemy extends AbstractCharacter {

  private int strength;
  private final int weight;

  /**
   * Creates a new enemy.
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
               int health, int defense,
               int strength, final int weight) {
    super(name, turnsQueue, health, defense);
    this.strength = strength;
    this.weight = weight;
  }

  /**
   * Returns the strength of this enemy.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Attacks a player character
   * @param opponent
   *     the player character to be attacked
   */
  public void attack(IPlayerCharacter opponent) {
    if (((ICharacter)opponent).getHealth() > 0) {
      ((ICharacter)opponent).getAttacked(this.getStrength());
      if (((ICharacter)opponent).getHealth() == 0) {
        event.firePropertyChange("Player character defeated", null, opponent);
      }
    }
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public String getSprite() {
    return "Enemy.png";
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    final Enemy that = (Enemy) o;
    return getStrength() == that.getStrength()
            && getWeight() == that.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), Enemy.class, getStrength(), getWeight());
  }
}
