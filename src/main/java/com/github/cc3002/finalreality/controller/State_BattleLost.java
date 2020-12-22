package com.github.cc3002.finalreality.controller;

/**
 * A state active when all the player characters have
 * been defeated
 */
public class State_BattleLost extends State {

    @Override
    public void win() {
        error();
    }

    @Override
    public void lose() {
        error();
    }

    @Override
    public boolean isBattleLost() {
        return true;
    }
}
