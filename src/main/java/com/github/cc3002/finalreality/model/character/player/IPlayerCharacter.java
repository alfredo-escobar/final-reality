package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a playable character from the game
 * (controlled by the player).
 *
 * @author Ignacio Slater Muñoz.
 */
public interface IPlayerCharacter {

    /**
     * Tries to equip a weapon to the character.
     * Returns true if the weapon was successfully equipped,
     * returns false otherwise.
     */
    boolean equip(IWeapon weapon);

    /**
     * Return this character's equipped weapon.
     */
    IWeapon getEquippedWeapon();

    /**
     * Attacks an enemy
     * @param opponent
     *     the enemy to be attacked
     */
    void attack(Enemy opponent);
}
