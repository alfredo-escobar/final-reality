package com.github.cc3002.finalreality.controller.states;

public class PartyReady extends State {

    public void win() {
        this.changeState(new BattleWon());
    }

    public void lose() {
        this.changeState(new BattleLost());
    }

    public boolean isPartyReady() {
        return true;
    }
}
