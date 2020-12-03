package com.github.cc3002.finalreality.controller.states;

import com.github.cc3002.finalreality.controller.GameController;

public class State {
    private GameController controller;

    public void setController(GameController controller) {
        this.controller = controller;
    }

    protected void changeState(State state) {
        controller.setState(state);
    }

    void error() {
        throw new AssertionError("Wrong state");
    }

    public void ready() {
        error();
    }

    public void win() {
        error();
    }

    public void lose() {
        error();
    }

    public boolean isPreparingParty() {
        return false;
    }

    public boolean isPartyReady() {
        return false;
    }

    public boolean isBattleWon() {
        return false;
    }

    public boolean isBattleLost() {
        return false;
    }
}
