package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all playable characters
 * in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class PlayerCharacter extends AbstractCharacter implements IPlayerCharacter {

  protected IWeapon equippedWeapon = null;

  protected PlayerCharacter(@NotNull final String name,
                            @NotNull BlockingQueue<ICharacter> turnsQueue,
                            int health, int defense,
                            IWeapon weapon) {
    super(name, turnsQueue, health, defense);
    if (weapon != null) {
      this.equip(weapon);
    }
  }

  @Override
  public boolean equip(IWeapon weapon) {
    if (weapon.canGenericCharacterEquip()) {
      this.equippedWeapon = weapon;
      return true;
    }
    return false;
  }

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public void attack(Enemy opponent) {
    if (this.equippedWeapon != null) {
      if (opponent.getHealth() > 0) {
        opponent.getAttacked(this.equippedWeapon.getDamage());
        if (opponent.getHealth() == 0) {
          event.firePropertyChange("Enemy defeated", null, opponent);
        }
      }
    }
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o.getClass() != this.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return Objects.equals(getEquippedWeapon(), that.getEquippedWeapon());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), PlayerCharacter.class, getEquippedWeapon());
  }
}
