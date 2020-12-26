package com.github.cc3002.finalreality.controller;

/**
 * A state active when the game is taking the
 * first character off the turns queue, and adding
 * them to the end of the queue
 */
public class State_EndOfTurn extends State{

    @Override
    public void setSelectingFirstInQueue() {
        this.changeState(new State_SelectingFirstInQueue());
    }

    @Override
    public boolean isEndOfTurn() {
        return true;
    }

    @Override
    public void endTurn() {
        controller.endTurn();
    }

    public void checkInQueue() {
        controller.checkInQueue();
    }
}
