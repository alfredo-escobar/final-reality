package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.states.PartyReady;
import com.github.cc3002.finalreality.controller.states.PreparingParty;
import com.github.cc3002.finalreality.controller.states.State;
import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class GameController {

    private final ArrayList<IPlayerCharacter> party = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> inventory = new ArrayList<>();
    private final IEventHandler handler = new Handler(this);
    private State state;

    protected BlockingQueue<ICharacter> turns;
    // private ICharacter currentCharacter = null;

    public GameController() {
        this.setState(new PreparingParty());
    }

    public void setState(State aState) {
        state = aState;
        state.setController(this);
    }

    public boolean isPreparingParty() {
        return state.isPreparingParty();
    }

    public boolean isPartyReady() {
        return state.isPartyReady();
    }

    public boolean isBattleWon() {
        return state.isBattleWon();
    }

    public boolean isBattleLost() {
        return state.isBattleLost();
    }

    public void addKnight(final String name,
                          int health, int defense,
                          IWeapon weapon) {
        if (state.isPreparingParty()) {
            party.add(new Knight(name, turns, health, defense, weapon));
            ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
            ((ICharacter)(party.get(party.size() - 1))).waitTurn();
            if (party.size() == 4) {
                state.ready();
            }
        }
    }

    public void addEngineer(final String name,
                            int health, int defense,
                            IWeapon weapon) {
        if (state.isPreparingParty()) {
            party.add(new Engineer(name, turns, health, defense, weapon));
            ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
            ((ICharacter)(party.get(party.size() - 1))).waitTurn();
            if (party.size() == 4) {
                state.ready();
            }
        }
    }

    public void addThief(final String name,
                         int health, int defense,
                         IWeapon weapon) {
        if (state.isPreparingParty()) {
            party.add(new Thief(name, turns, health, defense, weapon));
            ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
            ((ICharacter)(party.get(party.size() - 1))).waitTurn();
            if (party.size() == 4) {
                state.ready();
            }
        }
    }

    public void addBlackMage(final String name,
                             int health, int defense,
                             IWeapon weapon,
                             int mana) {
        if (state.isPreparingParty()) {
            party.add(new BlackMage(name, turns, health, defense, weapon, mana));
            ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
            ((ICharacter)(party.get(party.size() - 1))).waitTurn();
            if (party.size() == 4) {
                state.ready();
            }
        }
    }

    public void addWhiteMage(final String name,
                             int health, int defense,
                             IWeapon weapon,
                             int mana) {
        if (state.isPreparingParty()) {
            party.add(new WhiteMage(name, turns, health, defense, weapon, mana));
            ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
            ((ICharacter)(party.get(party.size() - 1))).waitTurn();
            if (party.size() == 4) {
                state.ready();
            }
        }
    }

    public void addEnemy(final String name,
                         int health, int defense,
                         int strength, int weight) {
        if (enemies.size() < 6) {
            enemies.add(new Enemy(name, turns, health, defense, strength, weight));
            enemies.get(enemies.size() - 1).addListener(handler);
            enemies.get(enemies.size() - 1).waitTurn();
        }
    }

    public void addSword(final String name, final int damage, final int weight) {
        inventory.add(new Sword(name, damage, weight));
    }

    public void addAxe(final String name, final int damage, final int weight) {
        inventory.add(new Axe(name, damage, weight));
    }

    public void addKnife(final String name, final int damage, final int weight) {
        inventory.add(new Knife(name, damage, weight));
    }

    public void addStaff(final String name, final int damage, final int weight,
                         final int magicDamage) {
        inventory.add(new Staff(name, damage, weight, magicDamage));
    }

    public void addBow(final String name, final int damage, final int weight) {
        inventory.add(new Bow(name, damage, weight));
    }

    public String getPlayerCharacterName(int index) {
        return ((AbstractCharacter)(party.get(index))).getName();
    }

    public int getPlayerCharacterHealth(int index) {
        return ((AbstractCharacter)(party.get(index))).getHealth();
    }

    public int getPlayerCharacterDefense(int index) {
        return ((AbstractCharacter)(party.get(index))).getDefense();
    }

    public IWeapon getPlayerCharacterWeapon(int index) {
        return party.get(index).getEquippedWeapon();
    }

    public int getPlayerCharacterMana(int index) {
        return ((AbstractMage)(party.get(index))).getMana();
    }

    public String getEnemyName(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getName();
    }

    public int getEnemyHealth(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getHealth();
    }

    public int getEnemyDefense(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getDefense();
    }

    public int getEnemyStrength(int index) {
        return enemies.get(index).getStrength();
    }

    public int getEnemyWeight(int index) {
        return enemies.get(index).getWeight();
    }

    public String getWeaponName(int index) {
        return inventory.get(index).getName();
    }

    public int getWeaponDamage(int index) {
        return inventory.get(index).getDamage();
    }

    public int getWeaponWeight(int index) {
        return inventory.get(index).getWeight();
    }

    public int getWeaponMagicDamage(int index) {
        return ((Staff)(inventory.get(index))).getMagicDamage();
    }

    public void equipToCharacter(int weaponIndex, int partyIndex) {
        var bufferWeapon = party.get(partyIndex).getEquippedWeapon();
        // If the weapon was successfully equipped:
        if (party.get(partyIndex).equip(inventory.get(weaponIndex))) {
            inventory.remove(weaponIndex);
            if (bufferWeapon != null) {
                inventory.add(bufferWeapon);
            }
        }
    }

    public void attackAnEnemy(int partyIndex, int enemyIndex) {
        party.get(partyIndex).attack(enemies.get(enemyIndex));
    }

    public void attackAPlayableCharacter(int enemyIndex, int partyIndex) {
        enemies.get(enemyIndex).attack(party.get(partyIndex));
    }

    public void startTurn() {
        if (state.isPartyReady()) {
            var character = turns.poll();
            if (party.contains(character)) {
                // User action
                // this.currentCharacter = character;
            } else if (enemies.contains(character)) {
                // CPU action
                // this.currentCharacter = character;
            }
            endTurn(character);
        }
    }

    public void endTurn(ICharacter character) {
        if (turns.size() > 0) {
            startTurn();
        }
        character.waitTurn();
    }

//    public ICharacter getCurrentCharacter() {
//        return this.currentCharacter;
//    }

    public void onPlayerCharacterDefeat(IPlayerCharacter character) {
        party.remove(character);
        if (party.size() == 0) {
            state.lose();
        }
    }

    public void onEnemyDefeat(Enemy character) {
        enemies.remove(character);
        if (enemies.size() == 0) {
            state.win();
        }
    }
}
