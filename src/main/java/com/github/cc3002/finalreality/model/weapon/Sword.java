package com.github.cc3002.finalreality.model.weapon;

/**
 * A class that holds all the information of a single sword of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Sword extends Weapon {

    /**
     * Creates a new sword.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage points
     * @param weight
     *     the weapon's weight
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name, damage, weight);
    }
}
