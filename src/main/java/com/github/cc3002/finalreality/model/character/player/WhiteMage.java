package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends AbstractMage {

    protected WhiteMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int strength, int defense,
                        Weapon equippedWeapon,
                        int mana) {
        super(name, turnsQueue, CharacterClass.WHITE_MAGE, health, strength, defense, equippedWeapon, mana);
    }

    protected WhiteMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int strength, int defense,
                        int mana) {
        super(name, turnsQueue, CharacterClass.WHITE_MAGE, health, strength, defense, null, mana);
    }
}
