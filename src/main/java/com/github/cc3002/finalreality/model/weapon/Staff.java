package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a single staff of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Alfredo Escobar Urrea.
 */
public class Staff extends Weapon {

    private final int magicDamage;

    /**
     * Creates a new staff.
     *
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage points
     * @param weight
     *     the weapon's weight
     * @param magicDamage
     *     the weapon's magic damage points
     */
    public Staff(final String name, final int damage, final int weight,
                 final int magicDamage) {
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }

    /**
     * Returns this weapon's magic damage points.
     */
    public int getMagicDamage() {
        return magicDamage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Staff weapon = (Staff) o;
        return getMagicDamage() == weapon.getMagicDamage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Staff.class, getMagicDamage());
    }

    @Override
    public boolean canBlackMageEquip() {
        return true;
    };

    @Override
    public boolean canWhiteMageEquip() {
        return true;
    };
}
