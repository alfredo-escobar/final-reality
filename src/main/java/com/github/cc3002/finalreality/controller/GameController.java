package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * A class that manages the objects from the model package
 * and their methods.
 */
public class GameController {

    private final ArrayList<IPlayerCharacter> party = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> inventory = new ArrayList<>();
    private final IEventHandler handler = new Handler(this);

    protected BlockingQueue<ICharacter> turns;

<<<<<<< HEAD
    /**
     * Creates a new controller and sets its initial
     * state as "preparing party".
     */
    public GameController() {
        this.setState(new PreparingParty());
    }

    /**
     * Sets the state of the game
     * @param aState
     *      the state to be set.
     */
    public void setState(State aState) {
        state = aState;
        state.setController(this);
    }

    /**
     * Returns true if 4 player characters haven't
     * been created.
     */
    public boolean isPreparingParty() {
        return state.isPreparingParty();
    }

    /**
     * Returns true if 4 player characters have
     * been created, and neither the player or
     * the enemies have won.
     */
    public boolean isPartyReady() {
        return state.isPartyReady();
    }

    /**
     * Returns true if all the enemies have been
     * defeated.
     */
    public boolean isBattleWon() {
        return state.isBattleWon();
    }

    /**
     * Returns true if all the player characters
     * have been defeated.
     */
    public boolean isBattleLost() {
        return state.isBattleLost();
    }
=======
    public GameController() {}
>>>>>>> parent of 21d0950... Estados y coverage

    /**
     * Adds a knight with the given parameters
     * to the party.
     */
    public void addKnight(final String name,
                          int health, int defense) {
        if (party.size() < 4) {
            party.add(new Knight(name, turns, health, defense));
            ((AbstractCharacter)(party.get(party.size() - 1))).addListener(handler);
        }
    }

    /**
     * Adds an engineer with the given parameters
     * to the party.
     */
    public void addEngineer(final String name,
                            int health, int defense) {
        if (party.size() < 4) {
            party.add(new Engineer(name, turns, health, defense));
            ((AbstractCharacter)(party.get(party.size() - 1))).addListener(handler);
        }
    }

    /**
     * Adds a thief with the given parameters
     * to the party.
     */
    public void addThief(final String name,
                         int health, int defense) {
        if (party.size() < 4) {
            party.add(new Thief(name, turns, health, defense));
            ((AbstractCharacter)(party.get(party.size() - 1))).addListener(handler);
        }
    }

    /**
     * Adds a black mage with the given parameters
     * to the party.
     */
    public void addBlackMage(final String name,
                             int health, int defense,
                             int mana) {
        if (party.size() < 4) {
            party.add(new BlackMage(name, turns, health, defense, mana));
            ((AbstractCharacter)(party.get(party.size() - 1))).addListener(handler);
        }
    }

    /**
     * Adds a white mage with the given parameters
     * to the party.
     */
    public void addWhiteMage(final String name,
                             int health, int defense,
                             int mana) {
        if (party.size() < 4) {
            party.add(new WhiteMage(name, turns, health, defense, mana));
            ((AbstractCharacter)(party.get(party.size() - 1))).addListener(handler);
        }
    }

    /**
     * Adds an enemy with the given parameters
     * to the enemy group.
     */
    public void addEnemy(final String name,
                         int health, int defense,
                         int strength, int weight) {
        if (enemies.size() < 6) {
            enemies.add(new Enemy(name, turns, health, defense, strength, weight));
            enemies.get(enemies.size() - 1).addListener(handler);
        }
    }

    /**
     * Adds a sword with the given parameters
     * to the inventory.
     */
    public void addSword(final String name, final int damage, final int weight) {
        inventory.add(new Sword(name, damage, weight));
    }

    /**
     * Adds an axe with the given parameters
     * to the inventory.
     */
    public void addAxe(final String name, final int damage, final int weight) {
        inventory.add(new Axe(name, damage, weight));
    }

    /**
     * Adds a knife with the given parameters
     * to the inventory.
     */
    public void addKnife(final String name, final int damage, final int weight) {
        inventory.add(new Knife(name, damage, weight));
    }

    /**
     * Adds a staff with the given parameters
     * to the inventory.
     */
    public void addStaff(final String name, final int damage, final int weight,
                         final int magicDamage) {
        inventory.add(new Staff(name, damage, weight, magicDamage));
    }

    /**
     * Adds a bow with the given parameters
     * to the inventory.
     */
    public void addBow(final String name, final int damage, final int weight) {
        inventory.add(new Bow(name, damage, weight));
    }

    /**
     * Returns the name of the player character
     * on a given position of the party.
     * @param index
     *      the position of the character
     */
    public String getPlayerCharacterName(int index) {
        return ((AbstractCharacter)(party.get(index))).getName();
    }

    /**
     * Returns the health of the player character
     * on a given position of the party.
     * @param index
     *      the position of the character
     */
    public int getPlayerCharacterHealth(int index) {
        return ((AbstractCharacter)(party.get(index))).getHealth();
    }

    /**
     * Returns the defense of the player character
     * on a given position of the party.
     * @param index
     *      the position of the character
     */
    public int getPlayerCharacterDefense(int index) {
        return ((AbstractCharacter)(party.get(index))).getDefense();
    }

    /**
     * Returns the weapon of the player character
     * on a given position of the party.
     * @param index
     *      the position of the character
     */
    public IWeapon getPlayerCharacterWeapon(int index) {
        return party.get(index).getEquippedWeapon();
    }

    /**
     * Returns the mana of the player character
     * on a given position of the party.
     * @param index
     *      the position of the character
     */
    public int getPlayerCharacterMana(int index) {
        return ((AbstractMage)(party.get(index))).getMana();
    }

    /**
     * Returns the name of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public String getEnemyName(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getName();
    }

    /**
     * Returns the health of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyHealth(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getHealth();
    }

    /**
     * Returns the defense of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyDefense(int index) {
        return ((AbstractCharacter)(enemies.get(index))).getDefense();
    }

    /**
     * Returns the strength of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyStrength(int index) {
        return enemies.get(index).getStrength();
    }

    /**
     * Returns the weight of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyWeight(int index) {
        return enemies.get(index).getWeight();
    }

    /**
     * Returns the name of the weapon
     * on a given position of the inventory.
     * @param index
     *      the position of the weapon
     */
    public String getWeaponName(int index) {
        return inventory.get(index).getName();
    }

<<<<<<< HEAD
    /**
     * Returns the damage of the weapon
     * on a given position of the inventory.
     * @param index
     *      the position of the weapon
     */
    public int getWeaponDamage(int index) {
=======
    public int getEnemyDamage(int index) {
>>>>>>> parent of 21d0950... Estados y coverage
        return inventory.get(index).getDamage();
    }

    /**
     * Returns the weight of the weapon
     * on a given position of the inventory.
     * @param index
     *      the position of the weapon
     */
    public int getWeaponWeight(int index) {
        return inventory.get(index).getWeight();
    }

    /**
     * Returns the magic damage of the weapon
     * on a given position of the inventory.
     * @param index
     *      the position of the weapon
     */
    public int getWeaponMagicDamage(int index) {
        return ((Staff)(inventory.get(index))).getMagicDamage();
    }

    /**
     * Equips a weapon to a player character
     * @param weaponIndex
     *      the position in the inventory of the weapon
     * @param partyIndex
     *      the position in the party of the player character
     */
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

    /**
     * Makes a player character attack an enemy
     * @param partyIndex
     *      the position in the party of the player character
     * @param enemyIndex
     *      the position in the enemy group of the enemy
     */
    public void attackAnEnemy(int partyIndex, int enemyIndex) {
        party.get(partyIndex).attack(enemies.get(enemyIndex));
    }

    /**
     * Makes an enemy attack player character
     * @param enemyIndex
     *      the position in the enemy group of the enemy
     * @param partyIndex
     *      the position in the party of the player character
     */
    public void attackAPlayableCharacter(int enemyIndex, int partyIndex) {
        enemies.get(enemyIndex).attack(party.get(partyIndex));
    }

    /**
     * Takes the first character in the turns queue and
     * makes it do an action
     */
    public void startTurn() {
        var character = turns.poll();
        if (party.contains(character)) {
            // User action
        } else if (enemies.contains(character)) {
            // CPU action
        }
        endTurn(character);
    }

    /**
     * Takes a character in an active turn and
     * makes it wait on the turns queue. If there is
     * another character on the queue, calls startTurn()
     * @param character
     *      the character whose turn is to be ended
     */
    public void endTurn(ICharacter character) {
        if (turns.size() > 0) {
            startTurn();
        }
        character.waitTurn();
    }

<<<<<<< HEAD
//    public ICharacter getCurrentCharacter() {
//        return this.currentCharacter;
//    }

    /**
     * Removes a defeated player character from the party.
     * If the party is empty, changes the state of the controller
     * @param character
     *      the defeated player character
     */
=======
>>>>>>> parent of 21d0950... Estados y coverage
    public void onPlayerCharacterDefeat(IPlayerCharacter character) {
        party.remove(character);
        if (party.size() == 0) {
            System.out.println("You lost");
        }
    }

    /**
     * Removes a defeated enemy from the enemy group.
     * If there are no more enemies left, changes the state of
     * the controller
     * @param character
     *      the defeated enemy
     */
    public void onEnemyDefeat(Enemy character) {
        enemies.remove(character);
        if (enemies.size() == 0) {
            System.out.println("You won");
        }
    }
}
