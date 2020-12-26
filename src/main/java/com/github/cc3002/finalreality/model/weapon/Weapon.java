package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class Weapon implements IWeapon{

  private final String name;
  private final int damage;
  private final int weight;

  protected Weapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean canKnightEquip() {
    return false;
  };

  @Override
  public boolean canEngineerEquip() {
    return false;
  };

  @Override
  public boolean canThiefEquip() {
    return false;
  };

  @Override
  public boolean canBlackMageEquip() {
    return false;
  };

  @Override
  public boolean canWhiteMageEquip() {
    return false;
  };

  @Override
  public boolean canGenericCharacterEquip() {
    return false;
  };

  @Override
  public String getSprite() {
    return " ";
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, getName(), getDamage(), getWeight());
  }
}
