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
    public void setPartyReady() {}

    /**
     * Changes the state to "Battle Won"
     */
    public void setBattleWon() {
        this.changeState(new State_BattleWon());
    }

    /**
     * Changes the state to "Battle Lost"
     */
    public void setBattleLost() {
        this.changeState(new State_BattleLost());
    }

    /**
     * Changes the state to "Selecting First In Queue".
     */
    public void setSelectingFirstInQueue() {
        error();
    }

    /**
     * Changes the state to "Player Turn".
     */
    public void setPlayerTurn() {
        error();
    }

    /**
     * Changes the state to "Enemy Turn".
     */
    public void setEnemyTurn() {
        error();
    }

    /**
     * Changes the state to "End Of Turn".
     */
    public void setEndOfTurn() {
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
     * Returns true if the current state is "End Of Turn"
     */
    public boolean isEndOfTurn() {
        return false;
    }

    /**
     * Returns true if the current state is "Selecting First In Queue"
     */
    public boolean isSelectingFirstInQueue() {
        return false;
    }

    /**
     * Adds a Player Character
     * For state: Preparing Party.
     */
    public void addPlayerCharacter(IPlayerCharacter playerCharacter) {}

    /**
     * Starts the timer of every character.
     * For state: Party Ready.
     */
    public void setAllTimers() {}

    /**
     * Checks if there is a character in the
     * turns queue, or waits for them to arrive.
     * For state: End Of Turn.
     */
    public void checkInQueue() {}

    /**
     * Starts the action of the first character in the turns queue.
     * For state: Selecting First In Queue.
     */
    public void prepareForCharAction() {}

    /**
     * Makes a playable character equip a weapon.
     * For state: Player Turn.
     */
    public void equipToCharacter(int partyIndex, int weaponIndex) {}

    /**
     * Makes a playable character attack an enemy.
     * For state: Player Turn.
     */
    public void attackAnEnemy(int partyIndex, int enemyIndex) {}

    /**
     * Makes an enemy attack a playable character.
     * For state: Enemy Turn.
     */
    public void attackAPlayerCharacter(int enemyIndex, int partyIndex) {}

    /**
     * Takes a character in an active turn and
     * makes it wait on the turns queue.
     * For state: End Of Turn.
     */
    public void endTurn() {}
}
