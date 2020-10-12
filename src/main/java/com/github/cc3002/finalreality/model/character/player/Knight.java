package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter {

    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int health, int strength, int defense,
                  Weapon equippedWeapon) {
        super(name, turnsQueue, CharacterClass.KNIGHT, health, strength, defense, equippedWeapon);
    }

    public Knight(@NotNull String name,
                  @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int health, int strength, int defense) {
        super(name, turnsQueue, CharacterClass.KNIGHT, health, strength, defense, null);
    }
}
