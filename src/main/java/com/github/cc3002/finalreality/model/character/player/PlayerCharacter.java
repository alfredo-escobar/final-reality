package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.CharacterClass;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all playable characters
 * in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar Urrea.
 */
public abstract class PlayerCharacter extends AbstractCharacter {

  protected PlayerCharacter(@NotNull final String name,
                            @NotNull BlockingQueue<ICharacter> turnsQueue,
                            final CharacterClass characterClass,
                            int health, int strength, int defense,
                            Weapon equippedWeapon) {
    super(name, turnsQueue, characterClass, health, strength, defense, equippedWeapon);
  }

  @Override
  public void equip(Weapon weapon) { this.equippedWeapon = weapon; }
}
