package com.github.cc3002.finalreality.controller;

/**
 * A state active when the game is waiting
 * for the first character in the turns queue.
 */
public class State_SelectingFirstInQueue extends State {

    @Override
    public void setPlayerTurn() {
        this.changeState(new State_PlayerTurn());
    }

    @Override
    public void setEnemyTurn() {
        this.changeState(new State_EnemyTurn());
    }

    @Override
    public boolean isSelectingFirstInQueue() {
        return true;
    }

    @Override
    public void prepareForCharAction() {
        controller.prepareForCharAction();
    }
}
