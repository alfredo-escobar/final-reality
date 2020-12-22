package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class that manages the objects from the model package
 * and their methods.
 */
public class GameController {

    private final ArrayList<IPlayerCharacter> party = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> inventory = new ArrayList<>();
    private final IEventHandler handler = new Handler(this);
    private Integer activePlayerCharacters = 4;
    private Integer activeEnemies = 0;
    private State state;

    protected BlockingQueue<ICharacter> turns;

    /**
     * Creates a new controller and sets its initial
     * state as "preparing party".
     */
    public GameController() {
        this.setState(new State_PreparingParty());
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
     * been created, and the battle hasn't started yet.
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

    /**
     * Returns true if the current state is "Player Turn"
     */
    public boolean isPlayerTurn() {
        return state.isPlayerTurn();
    }

    /**
     * Returns true if the current state is "Enemy Turn"
     */
    public boolean isEnemyTurn() {
        return state.isEnemyTurn();
    }

    /**
     * Returns true if the current state is "Removing Character From Queue"
     */
    public boolean isRemovingCharacterFromQueue() {
        return state.isRemovingCharacterFromQueue();
    }

    /**
     * Returns true if the current state is "Selecting First In Queue"
     */
    public boolean isSelectingFirstInQueue() {
        return state.isSelectingFirstInQueue();
    }

    void addPlayerCharacter(IPlayerCharacter playerCharacter) {
        party.add(playerCharacter);
        ((ICharacter)(party.get(party.size() - 1))).addListener(handler);
        ((ICharacter)(party.get(party.size() - 1))).waitTurn();
        if (party.size() == 4) {
            state.ready();
        }
    }

    /**
     * Adds a knight with the given parameters
     * to the party.
     */
    public void addKnight(final String name,
                          int health, int defense,
                          IWeapon weapon) {
        state.addPlayerCharacter(new Knight(name, turns, health, defense, weapon));
    }

    /**
     * Adds an engineer with the given parameters
     * to the party.
     */
    public void addEngineer(final String name,
                            int health, int defense,
                            IWeapon weapon) {
        state.addPlayerCharacter(new Engineer(name, turns, health, defense, weapon));
    }

    /**
     * Adds a thief with the given parameters
     * to the party.
     */
    public void addThief(final String name,
                         int health, int defense,
                         IWeapon weapon) {
        state.addPlayerCharacter(new Thief(name, turns, health, defense, weapon));
    }

    /**
     * Adds a black mage with the given parameters
     * to the party.
     */
    public void addBlackMage(final String name,
                             int health, int defense,
                             IWeapon weapon,
                             int mana) {
        state.addPlayerCharacter(new BlackMage(name, turns, health, defense, weapon, mana));
    }

    /**
     * Adds a white mage with the given parameters
     * to the party.
     */
    public void addWhiteMage(final String name,
                             int health, int defense,
                             IWeapon weapon,
                             int mana) {
        state.addPlayerCharacter(new WhiteMage(name, turns, health, defense, weapon, mana));
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
            enemies.get(enemies.size() - 1).waitTurn();
            activeEnemies += 1;
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

    /**
     * Returns the damage of the weapon
     * on a given position of the inventory.
     * @param index
     *      the position of the weapon
     */
    public int getWeaponDamage(int index) {
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
     * Equips a weapon to the first player character
     * in the turns queue
     * @param weaponIndex
     *      the position in the inventory of the weapon
     */
    public void activePlayerCharEquips(int weaponIndex) {
        int partyIndex = party.indexOf(turns.element());
        state.equipToCharacter(partyIndex, weaponIndex);
    }

    void equipToCharacter(int partyIndex, int weaponIndex) {
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
     * Makes the first player character in the
     * turns queue attack an enemy.
     * @param enemyIndex
     *      the position in the enemy group of the enemy
     */
    public void activePlayerCharAttacksEnemy(int enemyIndex) {
        int partyIndex = party.indexOf(turns.element());
        state.attackAnEnemy(partyIndex, enemyIndex);
    }

    void attackAnEnemy(int partyIndex, int enemyIndex) {
        party.get(partyIndex).attack(enemies.get(enemyIndex));
        state.removeFromQueue();
        endTurn();
    }

    /**
     * Makes the first enemy in the turns
     * queue attack a player character.
     */
    public void activeEnemyAttacksPlayerChar() {
        int enemyIndex = enemies.indexOf(turns.element());
        int partyIndex = ThreadLocalRandom.current().nextInt(0, party.size());
        state.attackAPlayerCharacter(enemyIndex, partyIndex);
    }

    void attackAPlayableCharacter(int enemyIndex, int partyIndex) {
        enemies.get(enemyIndex).attack(party.get(partyIndex));
        state.removeFromQueue();
        endTurn();
    }

    /**
     * Starts the action of the first character in the turns queue
     * if current state is "Selecting First in Queue".
     */
    public void characterInQueue() {
        state.characterInQueue();
    }

    void startFirstInQueueTurn() {
        var character = turns.element();
        if (party.contains(character)) {
            state.startPlayerTurn();
        } else if (enemies.contains(character)) {
            state.startEnemyTurn();
            activeEnemyAttacksPlayerChar();
        } else {
            turns.poll();
            startFirstInQueueTurn();
        }
    }

    /**
     * Takes a character in an active turn and
     * makes it wait on the turns queue. If there is
     * another character on the queue, calls startTurn()
     */
    public void removeFirstFromQueue() {
        state.endTurn();
    }

    void endTurn() {
        var character = turns.poll();
        character.waitTurn();
        startTurn();
    }

    /**
     * Changes the state to "Selecting First In Queue".
     * If the turns queue is not empty, starts the turn
     * of the first character in the queue.
     */
    public void startTurn() {
        state.selectFirst();
        if (turns.size() > 0) {
            characterInQueue();
        }
    }

    /**
     * Removes a defeated player character from the party.
     * If the party is empty, changes the state of the controller
     * @param character
     *      the defeated player character
     */
    public void onPlayerCharacterDefeat(IPlayerCharacter character) {
        party.remove(character);
        if (party.size() == 0) {
            state.lose();
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
            state.win();
        }
    }
}
