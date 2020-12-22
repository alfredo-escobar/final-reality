package com.github.cc3002.finalreality.controller;

/**
 * A state active when all the enemies have been defeated
 */
public class State_BattleWon extends State {

    @Override
    public void win() {
        error();
    }

    @Override
    public void lose() {
        error();
    }

    @Override
    public boolean isBattleWon() {
        return true;
    }
}
