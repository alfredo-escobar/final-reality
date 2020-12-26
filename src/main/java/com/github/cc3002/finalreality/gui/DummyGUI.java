package com.github.cc3002.finalreality.gui;

public class DummyGUI implements IGUI{

    @Override
    public void updateInfo() {}

    @Override
    public void updatePlayerTurnScreen() {}

    @Override
    public void playerAttack(int enemyIndex, int enemyAmount, int dmgDealt) {}

    @Override
    public void enemyAttack(int partyIndex, int playerCharAmount, int dmgDealt) {}

    @Override
    public void gameWon() {}

    @Override
    public void gameLost() {}
}
