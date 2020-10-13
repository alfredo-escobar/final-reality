package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

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
     * @param strength
     *     the character's strength
     * @param defense
     *     the character's defense
     * @param equippedWeapon
     *     the character's initial equipped weapon
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int strength, int defense,
                 Weapon equippedWeapon) {
        super(name, turnsQueue, CharacterClass.THIEF, health, strength, defense, equippedWeapon);
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
     * @param strength
     *     the character's strength
     * @param defense
     *     the character's defense
     */
    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int strength, int defense) {
        super(name, turnsQueue, CharacterClass.THIEF, health, strength, defense, null);
    }
}
