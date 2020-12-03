package com.github.cc3002.finalreality.controller.states;

import com.github.cc3002.finalreality.controller.GameController;

/**
 * A class used to indicate the current state of the game
 */
public class State {
    private GameController controller;

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
    public void ready() {
        error();
    }

    /**
     * Changes the state to "Battle Won" if the current
     * state is "Party Ready".
     */
    public void win() {
        error();
    }

    /**
     * Changes the state to "Battle Lost" if the current
     * state is "Party Ready".
     */
    public void lose() {
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
}
