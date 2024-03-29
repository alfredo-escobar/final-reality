package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single white mage of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class WhiteMage extends AbstractMage {

    /**
     * Creates a new white mage with a weapon equipped.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param health
     *     the character's health points
     * @param defense
     *     the character's defense
     * @param equippedWeapon
     *     the character's initial equipped weapon
     * @param mana
     *     the character's mana
     */
    public WhiteMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int defense,
                        IWeapon equippedWeapon,
                        int mana) {
        super(name, turnsQueue, health, defense, equippedWeapon, mana);
    }

    /**
     * Creates a new white mage without a weapon equipped.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param health
     *     the character's health points
     * @param defense
     *     the character's defense
     * @param mana
     *     the character's mana
     */
    public WhiteMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int defense,
                        int mana) {
        super(name, turnsQueue, health, defense, null, mana);
    }

    @Override
    public boolean equip(IWeapon weapon) {
        if (weapon.canWhiteMageEquip()) {
            this.equippedWeapon = weapon;
            return true;
        }
        return false;
    }

    @Override
    public String getSprite() {
        return "WhiteMage.png";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), WhiteMage.class);
    }
}
