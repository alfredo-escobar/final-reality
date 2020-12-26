package com.github.cc3002.finalreality.controller;

/**
 * A state active when 4 player characters have
 * been created, but the battle hasn't started yet.
 */
public class State_PartyReady extends State {

    @Override
    public void setEndOfTurn() {
        this.changeState(new State_EndOfTurn());
    }

    @Override
    public void setBattleWon() {
        error();
    }

    @Override
    public void setBattleLost() {
        error();
    }

    @Override
    public boolean isPartyReady() {
        return true;
    }

    @Override
    public void setAllTimers() {
        controller.setAllTimers();
    }
}
