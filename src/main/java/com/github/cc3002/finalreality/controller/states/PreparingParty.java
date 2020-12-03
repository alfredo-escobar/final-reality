package com.github.cc3002.finalreality.controller.states;

public class PreparingParty extends State {

    public void ready() {
        this.changeState(new PartyReady());
    }

    public boolean isPreparingParty() {
        return true;
    }
}
