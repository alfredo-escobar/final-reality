package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a single knife of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Knife extends Weapon {

    /**
     * Creates a new knife.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage points
     * @param weight
     *     the weapon's weight
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.KNIFE);
    }
}
