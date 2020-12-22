package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class used to indicate the current state of the game
 */
public class State {
    GameController controller;

    /**
     * Links the state object with the given controller
     */
    public void setController(GameController controller) {
        this.controller = controller;
    }

    protected void changeState(State state) {
        controller.setState(state);
    }

    void error() {
        throw new AssertionError("Wrong state");
    }

    /**
     * Changes the state to "Party Ready" if the current
     * state is "Preparing Party".
     */
    public void ready() {}

    /**
     * Changes the state to "Battle Won"
     */
    public void win() {
        this.changeState(new State_BattleWon());
    }

    /**
     * Changes the state to "Battle Lost"
     */
    public void lose() {
        this.changeState(new State_BattleLost());
    }

    /**
     * Changes the state to "Selecting First In Queue".
     */
    public void selectFirst() {
        error();
    }

    /**
     * Changes the state to "Player Turn".
     */
    public void startPlayerTurn() {
        error();
    }

    /**
     * Changes the state to "Enemy Turn".
     */
    public void startEnemyTurn() {
        error();
    }

    /**
     * Changes the state to "Removing Character From Queue".
     */
    public void removeFromQueue() {
        error();
    }

    /**
     * Returns true if the current state is "Preparing Party"
     */
    public boolean isPreparingParty() {
        return false;
    }

    /**
     * Returns true if the current state is "Party Ready"
     */
    public boolean isPartyReady() {
        return false;
    }

    /**
     * Returns true if the current state is "Battle Won"
     */
    public boolean isBattleWon() {
        return false;
    }

    /**
     * Returns true if the current state is "Battle Won"
     */
    public boolean isBattleLost() {
        return false;
    }

    /**
     * Returns true if the current state is "Player Turn"
     */
    public boolean isPlayerTurn() {
        return false;
    }

    /**
     * Returns true if the current state is "Enemy Turn"
     */
    public boolean isEnemyTurn() {
        return false;
    }

    /**
     * Returns true if the current state is "Removing Character From Queue"
     */
    public boolean isRemovingCharacterFromQueue() {
        return false;
    }

    /**
     * Returns true if the current state is "Selecting First In Queue"
     */
    public boolean isSelectingFirstInQueue() {
        return false;
    }

    /**
     * Adds a Player Character if current state is "Preparing Party"
     */
    public void addPlayerCharacter(IPlayerCharacter playerCharacter) {}

    /**
     * Starts the action of the first character in the turns queue
     * if current state is "Selecting First in Queue".
     */
    public void characterInQueue() {}

    /**
     * Makes a playable character equip a weapon
     * if current state is "Player Turn".
     */
    public void equipToCharacter(int partyIndex, int weaponIndex) {}

    /**
     * Makes a playable character attack an enemy
     * if current state is "Player Turn".
     */
    public void attackAnEnemy(int partyIndex, int enemyIndex) {}

    /**
     * Makes an enemy attack a playable character
     * if current state is "Enemy Turn".
     */
    public void attackAPlayerCharacter(int enemyIndex, int partyIndex) {}

    /**
     * Takes a character in an active turn and
     * makes it wait on the turns queue,
     * if current state is "Removing Character From Queue".
     */
    public void endTurn() {}
}
