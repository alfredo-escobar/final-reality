package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.controller.IEventHandler;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;

import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final String name;
  protected final BlockingQueue<ICharacter> turnsQueue;
  private int health;
  private int defense;

  protected ScheduledExecutorService scheduledExecutor;
  protected final PropertyChangeSupport event = new PropertyChangeSupport(this);

  protected AbstractCharacter(@NotNull String name,
                              @NotNull BlockingQueue<ICharacter> turnsQueue,
                              int health, int defense) {
    this.name = name;
    this.turnsQueue = turnsQueue;
    this.health = health;
    this.defense = defense;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    if (turnsQueue.size() == 1) {
      event.firePropertyChange("Start of turn", null, this);
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void getAttacked(int damage) {
    if ((damage - this.defense)>0) {
      this.health -= (damage - this.defense);
      if (this.health < 0) {
        this.health = 0;
      }
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o.getClass() != this.getClass()) {
      return false;
    }
    final AbstractCharacter that = (AbstractCharacter) o;
    return getName().equals(that.getName())
            && getHealth() == that.getHealth()
            && getDefense() == that.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(AbstractCharacter.class, getName(),
            getHealth(), getDefense());
  }

  @Override
  public void addListener(IEventHandler handler) {
    event.addPropertyChangeListener(handler);
  }
}
