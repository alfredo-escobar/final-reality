package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends PlayerCharacter {

    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int strength, int defense,
                 Weapon equippedWeapon) {
        super(name, turnsQueue, CharacterClass.THIEF, health, strength, defense, equippedWeapon);
    }

    public Thief(@NotNull String name,
                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                 int health, int strength, int defense) {
        super(name, turnsQueue, CharacterClass.THIEF, health, strength, defense, null);
    }
}
