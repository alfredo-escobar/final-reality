package com.github.cc3002.finalreality.controller.states;

/**
 * A state active when 4 player characters haven't
 * been created.
 */
public class PreparingParty extends State {

    @Override
    public void ready() {
        this.changeState(new PartyReady());
    }

    @Override
    public boolean isPreparingParty() {
        return true;
    }
}
