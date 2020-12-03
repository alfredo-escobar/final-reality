package com.github.cc3002.finalreality.controller.states;

/**
 * A state active when 4 player characters have
 * been created, and neither the player or
 * the enemies have won.
 */
public class PartyReady extends State {

    @Override
    public void win() {
        this.changeState(new BattleWon());
    }

    @Override
    public void lose() {
        this.changeState(new BattleLost());
    }

    @Override
    public boolean isPartyReady() {
        return true;
    }
}
