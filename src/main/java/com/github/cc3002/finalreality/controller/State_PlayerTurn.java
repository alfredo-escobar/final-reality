package com.github.cc3002.finalreality.controller;

/**
 * A state where the player character can equip weapons
 * and attack an enemy.
 */
public class State_PlayerTurn extends State {

    @Override
    public void removeFromQueue() {
        this.changeState(new State_RemovingCharacterFromQueue());
    }

    @Override
    public boolean isPlayerTurn() {
        return true;
    }

    @Override
    public void equipToCharacter(int partyIndex, int weaponIndex) {
        controller.equipToCharacter(partyIndex, weaponIndex);
    }

    @Override
    public void attackAnEnemy(int partyIndex, int enemyIndex) {
        controller.attackAnEnemy(partyIndex, enemyIndex);
    }
}
