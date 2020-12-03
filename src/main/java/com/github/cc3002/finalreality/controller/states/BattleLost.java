package com.github.cc3002.finalreality.controller.states;

/**
 * A state active when all the player characters have
 * been defeated
 */
public class BattleLost extends State {

    @Override
    public boolean isBattleLost() {
        return true;
    }
}
