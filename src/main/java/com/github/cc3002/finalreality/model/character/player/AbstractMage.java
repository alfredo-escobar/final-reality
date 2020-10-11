package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

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

    public int getMana() { return mana; }
}
