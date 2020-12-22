package com.github.cc3002.finalreality.controller;

/**
 * A state where the CPU chooses a player character to attack.
 */
public class State_EnemyTurn extends State{

    @Override
    public void removeFromQueue() {
        this.changeState(new State_RemovingCharacterFromQueue());
    }

    @Override
    public boolean isEnemyTurn() {
        return true;
    }

    @Override
    public void attackAPlayerCharacter(int enemyIndex, int partyIndex) {
        controller.attackAPlayableCharacter(enemyIndex, partyIndex);
    }
}
