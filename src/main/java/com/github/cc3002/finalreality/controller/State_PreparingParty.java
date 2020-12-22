package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A state active when 4 player characters haven't
 * been created.
 */
public class State_PreparingParty extends State {

    @Override
    public void win() {
        error();
    }

    @Override
    public void lose() {
        error();
    }

    @Override
    public void ready() {
        this.changeState(new State_PartyReady());
    }

    @Override
    public boolean isPreparingParty() {
        return true;
    }

    @Override
    public void addPlayerCharacter(IPlayerCharacter playerCharacter) {
        controller.addPlayerCharacter(playerCharacter);
    }
}
