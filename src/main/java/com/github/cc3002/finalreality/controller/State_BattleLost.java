package com.github.cc3002.finalreality.controller;

/**
 * A state active when all the player characters have
 * been defeated
 */
public class State_BattleLost extends State {

    @Override
    public void setBattleWon() {
        error();
    }

    @Override
    public void setBattleLost() {
        error();
    }

    @Override
    public void setSelectingFirstInQueue() {}

    @Override
    public void setPlayerTurn() {}

    @Override
    public void setEnemyTurn() {}

    @Override
    public void setEndOfTurn() {}

    @Override
    public boolean isBattleLost() {
        return true;
    }
}
