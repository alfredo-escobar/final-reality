package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds all the information of a single magic-type character of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public abstract class AbstractMage extends PlayerCharacter {

    private int mana;

    protected AbstractMage(@NotNull String name,
                           @NotNull BlockingQueue<ICharacter> turnsQueue,
                           final CharacterClass characterClass,
                           int health, int strength, int defense,
                           Weapon equippedWeapon,
                           int mana) {
        super(name, turnsQueue, characterClass, health, strength, defense, equippedWeapon);
        this.mana = mana;
    }

    /**
     * Returns the mana of this mage.
     */
    public int getMana() { return mana; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractMage)) {
            return false;
        }
        final AbstractMage that = (AbstractMage) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName())
                && getHealth() == that.getHealth()
                && getStrength() == that.getStrength()
                && getDefense() == that.getDefense()
                && getMana() == that.getMana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getName(),
                getHealth(), getStrength(), getDefense(),
                getMana());
    }
}
