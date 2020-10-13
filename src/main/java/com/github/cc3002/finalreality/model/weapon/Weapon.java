package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of all the weapons in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class Weapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType type;

  protected Weapon(final String name, final int damage, final int weight,
                   final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  /**
   * Returns this weapon's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns this weapon's damage points.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns this weapon's weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns this weapon's type
   */
  public WeaponType getType() {
    return type;
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
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}
