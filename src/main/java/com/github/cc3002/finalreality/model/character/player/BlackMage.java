package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single black mage of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class BlackMage extends AbstractMage {

    /**
     * Creates a new black mage with a weapon equipped.
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
    public BlackMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int defense,
                        IWeapon equippedWeapon,
                        int mana) {
        super(name, turnsQueue, health, defense, equippedWeapon, mana);
    }

    /**
     * Creates a new black mage without a weapon equipped.
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
    public BlackMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int defense,
                        int mana) {
        super(name, turnsQueue, health, defense, null, mana);
    }

    @Override
    public boolean equip(IWeapon weapon) {
        if (weapon.canBlackMageEquip()) {
            this.equippedWeapon = weapon;
            return true;
        }
        return false;
    }

    @Override
    public String getSprite() {
        return "BlackMage.png";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), BlackMage.class);
    }
}
