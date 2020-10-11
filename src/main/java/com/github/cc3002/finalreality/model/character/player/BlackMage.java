package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends AbstractMage {

    protected BlackMage(@NotNull String name,
                        @NotNull BlockingQueue<ICharacter> turnsQueue,
                        int health, int strength, int defense,
                        Weapon equippedWeapon,
                        int mana) {
        super(name, turnsQueue, CharacterClass.BLACK_MAGE, health, strength, defense, equippedWeapon, mana);
    }
}
