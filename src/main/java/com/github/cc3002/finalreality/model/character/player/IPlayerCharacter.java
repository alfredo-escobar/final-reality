package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a playable character from the game
 * (controlled by the player).
 *
 * @author Ignacio Slater Muñoz.
 */
public interface IPlayerCharacter {

    /**
     * Equips a weapon to the character.
     */
    void equip(IWeapon weapon);

    /**
     * Return this character's equipped weapon.
     */
    IWeapon getEquippedWeapon();
}
