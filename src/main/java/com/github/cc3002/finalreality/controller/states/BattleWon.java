package com.github.cc3002.finalreality.controller.states;

/**
 * A state active when all the enemies have been defeated
 */
public class BattleWon extends State {

    @Override
    public boolean isBattleWon() {
        return true;
    }
}
