package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single thief of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Thief extends PlayerCharacter {

    /**
     * Creates a new thief with a weapon equipped.
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
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int defense,
                 IWeapon equippedWeapon) {
        super(name, turnsQueue, health, defense, equippedWeapon);
    }

    /**
     * Creates a new thief without a weapon equipped.
     *
     * @param name
     *     the character's name
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param health
     *     the character's health points
     * @param defense
     *     the character's defense
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int defense) {
        super(name, turnsQueue, health, defense, null);
    }

    @Override
    public boolean equip(IWeapon weapon) {
        if (weapon.canThiefEquip()) {
            this.equippedWeapon = weapon;
            return true;
        }
        return false;
    }

    @Override
    public String getSprite() {
        return "Thief.png";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Thief.class);
    }
}
