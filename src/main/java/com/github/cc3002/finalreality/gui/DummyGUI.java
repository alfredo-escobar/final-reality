package com.github.cc3002.finalreality.gui;

public class DummyGUI implements IGUI{

    @Override
    public void updateInfo() {}

    @Override
    public void updatePlayerTurnScreen() {}

    @Override
    public void playerAttack(int enemyIndex, int dmgDealt) {}

    @Override
    public void enemyAttack(int partyIndex, int dmgDealt) {}

    @Override
    public void gameWon() {}

    @Override
    public void gameLost() {}
}
