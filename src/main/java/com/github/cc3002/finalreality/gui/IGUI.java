package com.github.cc3002.finalreality.gui;

/**
 * Graphical user interface.
 * Contains methods for on-screen
 * content management.
 *
 * @author Alfredo Escobar Urrea.
 */
public interface IGUI {

    /**
     * Shows/updates the character sprites
     * and character health information.
     */
    void updateInfo();

    /**
     * Shows/updates the name and weapon of the active
     * player character, the buttons for attacking
     * enemies and the inventory.
     */
    void updatePlayerTurnScreen();

    /**
     * Shows the amount of damage an enemy has received.
     * @param enemyIndex
     *      the position of the enemy.
     * @param enemyAmount
     *      the amount of enemies at the time
     *      of the attack.
     * @param dmgDealt
     *      the damage taken by the enemy.
     */
    void playerAttack(int enemyIndex, int enemyAmount, int dmgDealt);

    /**
     * Shows the amount of damage a player character
     * has received.
     * @param partyIndex
     *      the position of the player character.
     * @param playerCharAmount
     *      the amount of player characters at the
     *      time of the attack.
     * @param dmgDealt
     *      the damage taken by the enemy.
     */
    void enemyAttack(int partyIndex, int playerCharAmount, int dmgDealt);

    /**
     * Shows the Game Won screen.
     */
    void gameWon();

    /**
     * Shows the Game Lost screen.
     */
    void gameLost();
}
