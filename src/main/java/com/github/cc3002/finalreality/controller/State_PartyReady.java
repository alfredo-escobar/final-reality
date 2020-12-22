package com.github.cc3002.finalreality.controller;

/**
 * A state active when 4 player characters have
 * been created, but the battle hasn't started yet.
 */
public class State_PartyReady extends State {

    @Override
    public void selectFirst() {
        this.changeState(new State_SelectingFirstInQueue());
    }

    @Override
    public void win() {
        error();
    }

    @Override
    public void lose() {
        error();
    }

    @Override
    public boolean isPartyReady() {
        return true;
    }
}
