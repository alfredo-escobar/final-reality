package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.gui.DummyGUI;
import com.github.cc3002.finalreality.gui.IGUI;
import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class that manages the objects from the model package
 * and their methods.
 */
public class GameController {

    private final ArrayList<IPlayerCharacter> party = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();
    private final ArrayList<IWeapon> inventory = new ArrayList<>();
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();

    private final IEventHandler handler = new Handler(this);
    private State state;
    private IGUI gui;

    /**
     * Creates a new controller and sets its initial
     * state as "preparing party".
     */
    public GameController() {
        this.setState(new State_PreparingParty());
        this.setGUI(new DummyGUI());
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
     * Links a graphical user interface to this controller.
     * @param gui
     *       the GUI to be linked.
     */
    public void setGUI (IGUI gui) {
        this.gui = gui;
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
        return state.isEndOfTurn();
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
        if (party.size() == 4) {
            state.setPartyReady();
        }
    }

    /**
     * Adds a knight with a sword with the
     * given parameters to the party.
     */
    public void addKnightWithSword(final String characterName,
                                   int health, int defense,
                                   final String weaponName,
                                   final int damage, final int weight) {
        var weapon = new Sword(weaponName, damage, weight);
        state.addPlayerCharacter(new Knight(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a knight with an axe with the
     * given parameters to the party.
     */
    public void addKnightWithAxe(final String characterName,
                                   int health, int defense,
                                   final String weaponName,
                                   final int damage, final int weight) {
        var weapon = new Axe(weaponName, damage, weight);
        state.addPlayerCharacter(new Knight(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a knight with a knife with the
     * given parameters to the party.
     */
    public void addKnightWithKnife(final String characterName,
                                 int health, int defense,
                                 final String weaponName,
                                 final int damage, final int weight) {
        var weapon = new Knife(weaponName, damage, weight);
        state.addPlayerCharacter(new Knight(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds an engineer with an axe with the
     * given parameters to the party.
     */
    public void addEngineerWithAxe(final String characterName,
                                 int health, int defense,
                                 final String weaponName,
                                 final int damage, final int weight) {
        var weapon = new Axe(weaponName, damage, weight);
        state.addPlayerCharacter(new Engineer(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds an engineer with a bow with the
     * given parameters to the party.
     */
    public void addEngineerWithBow(final String characterName,
                                   int health, int defense,
                                   final String weaponName,
                                   final int damage, final int weight) {
        var weapon = new Bow(weaponName, damage, weight);
        state.addPlayerCharacter(new Engineer(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a thief with a sword with the
     * given parameters to the party.
     */
    public void addThiefWithSword(final String characterName,
                                   int health, int defense,
                                   final String weaponName,
                                   final int damage, final int weight) {
        var weapon = new Sword(weaponName, damage, weight);
        state.addPlayerCharacter(new Thief(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a thief with a knife with the
     * given parameters to the party.
     */
    public void addThiefWithKnife(final String characterName,
                                  int health, int defense,
                                  final String weaponName,
                                  final int damage, final int weight) {
        var weapon = new Knife(weaponName, damage, weight);
        state.addPlayerCharacter(new Thief(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a thief with a bow with the
     * given parameters to the party.
     */
    public void addThiefWithBow(final String characterName,
                                  int health, int defense,
                                  final String weaponName,
                                  final int damage, final int weight) {
        var weapon = new Bow(weaponName, damage, weight);
        state.addPlayerCharacter(new Thief(characterName, turns, health, defense, weapon));
    }

    /**
     * Adds a black mage with a knife with the
     * given parameters to the party.
     */
    public void addBlackMageWithKnife(final String characterName,
                                  int health, int defense, int mana,
                                  final String weaponName,
                                  final int damage, final int weight) {
        var weapon = new Knife(weaponName, damage, weight);
        state.addPlayerCharacter(new BlackMage(characterName, turns, health, defense, weapon, mana));
    }

    /**
     * Adds a black mage with a staff with the
     * given parameters to the party.
     */
    public void addBlackMageWithStaff(final String characterName,
                                int health, int defense, int mana,
                                final String weaponName,
                                final int damage, final int weight,
                                final int magicDamage) {
        var weapon = new Staff(weaponName, damage, weight, magicDamage);
        state.addPlayerCharacter(new BlackMage(characterName, turns, health, defense, weapon, mana));
    }

    /**
     * Adds a white mage with a staff with the
     * given parameters to the party.
     */
    public void addWhiteMageWithStaff(final String characterName,
                                      int health, int defense, int mana,
                                      final String weaponName,
                                      final int damage, final int weight,
                                      final int magicDamage) {
        var weapon = new Staff(weaponName, damage, weight, magicDamage);
        state.addPlayerCharacter(new WhiteMage(characterName, turns, health, defense, weapon, mana));
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
     * Returns the name of the image file to be used
     * as a sprite for this playable character.
     * @param index
     *      the position of the character
     */
    public String getPlayerCharacterSprite(int index) {
        return ((ICharacter)party.get(index)).getSprite();
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
        return enemies.get(index).getName();
    }

    /**
     * Returns the health of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyHealth(int index) {
        return enemies.get(index).getHealth();
    }

    /**
     * Returns the defense of the enemy
     * on a given position of the enemy group.
     * @param index
     *      the position of the enemy
     */
    public int getEnemyDefense(int index) {
        return enemies.get(index).getDefense();
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
     * Returns the name of the image file to be used
     * as a sprite for this enemy.
     * @param index
     *      the position of the enemy
     */
    public String getEnemySprite(int index) {
        return enemies.get(index).getSprite();
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
     * Returns amount of player characters.
     */
    public int getAmountOfPlayerCharacters() {
        return party.size();
    }

    /**
     * Returns amount of enemies.
     */
    public int getAmountOfEnemies() {
        return enemies.size();
    }

    /**
     * Returns amount of weapons in inventory.
     */
    public int getAmountOfWeapons() {
        return inventory.size();
    }

    /**
     * Returns the active player character's index.
     */
    public int getActivePlayerCharIndex() {
        return party.indexOf(turns.element());
    }

    /**
     * Returns the active player character's name.
     */
    public String getActivePlayerCharName() {
        return turns.element().getName();
    }

    /**
     * Returns the active player character's weapon name.
     */
    public String getActivePlayerCharWeaponData() {
        var weapon = ((IPlayerCharacter)turns.element()).getEquippedWeapon();
        var name = weapon.getName();
        var damage = weapon.getDamage();
        return name + " (Damage: " + damage + ")";
    }

    /**
     * Returns the name of the image file to be used as a
     * sprite for the active player character's weapon.
     */
    public String getActivePlayerCharWeaponSprite() {
        var weapon = ((IPlayerCharacter)turns.element()).getEquippedWeapon();
        return weapon.getSprite();
    }





    /**
     * Starts the timer of every character.
     * For state: Party Ready.
     */
    public void startGame() {
        state.setAllTimers();
    }

    void setAllTimers() {
        for (IPlayerCharacter playerChar : party) {
            ((ICharacter)(playerChar)).waitTurn();
        }
        for (Enemy enemy : enemies) {
            enemy.waitTurn();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state.setEndOfTurn();
        startTurn();
    }

    /**
     * Checks if there is a character in the
     * turns queue, or waits for them to arrive.
     * For state: End Of Turn.
     */
    public void startTurn() {
        state.checkInQueue();
    }

    void checkInQueue() {
        state.setSelectingFirstInQueue();
        if (turns.size() > 0) {
            characterInQueue();
        }
    }

    /**
     * Starts the action of the first character in the turns queue
     * For state: Selecting First In Queue.
     */
    public void characterInQueue() {
        state.prepareForCharAction();
    }

    void prepareForCharAction() {
        var character = turns.element();
        if (party.contains(character)) {
            state.setPlayerTurn();
            gui.updatePlayerTurnScreen();
        } else if (enemies.contains(character)) {
            state.setEnemyTurn();
            activeEnemyAttacksPlayerChar();
        } else if (turns.size() > 1) {
            turns.poll();
            prepareForCharAction();
        }
    }

    /**
     * Equips a weapon to the first player character
     * in the turns queue.
     * For state: Player Turn.
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
            inventory.add(bufferWeapon);
        }
    }

    /**
     * Makes the first player character in the
     * turns queue attack an enemy.
     * For state: Player Turn.
     * @param enemyIndex
     *      the position in the enemy group of the enemy
     */
    public void activePlayerCharAttacksEnemy(int enemyIndex) {
        int partyIndex = party.indexOf(turns.element());
        state.attackAnEnemy(partyIndex, enemyIndex);
    }

    void attackAnEnemy(int partyIndex, int enemyIndex) {
        int enemyAmount = enemies.size();
        int dmgDealt = party.get(partyIndex).attack(enemies.get(enemyIndex));
        gui.playerAttack(enemyIndex, enemyAmount, dmgDealt);
        state.setEndOfTurn();
        removeFirstFromQueue();
    }

    /**
     * Makes the first enemy in the turns
     * queue attack a random player character.
     * For state: Enemy Turn.
     */
    public void activeEnemyAttacksPlayerChar() {
        int enemyIndex = enemies.indexOf(turns.element());
        int partyIndex = ThreadLocalRandom.current().nextInt(0, party.size());
        state.attackAPlayerCharacter(enemyIndex, partyIndex);
    }

    void attackAPlayableCharacter(int enemyIndex, int partyIndex) {
        int playerCharAmount = party.size();
        int dmgDealt = enemies.get(enemyIndex).attack(party.get(partyIndex));
        gui.enemyAttack(partyIndex, playerCharAmount, dmgDealt);
        state.setEndOfTurn();
        removeFirstFromQueue();
    }

    /**
     * Takes a character in an active turn and
     * makes it wait on the turns queue.
     * For state: End Of Turn
     */
    public void removeFirstFromQueue() {
        state.endTurn();
    }

    void endTurn() {
        gui.updateInfo();
        var character = turns.poll();
        character.waitTurn();
    }



    /**
     * Removes a defeated player character from the party.
     * If the party is empty, changes the state of the controller
     * @param character
     *      the defeated player character
     */
    public void onPlayerCharacterDefeat(IPlayerCharacter character) {
        party.remove(character);
        gui.updateInfo();
        if (party.size() == 0) {
            state.setBattleLost();
            gui.gameLost();
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
        gui.updateInfo();
        if (enemies.size() == 0) {
            state.setBattleWon();
            gui.gameWon();
        }
    }
}
