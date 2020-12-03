package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

/**
 * A class that manages calls from the model package
 */
public class Handler implements IEventHandler {
    private final GameController controller;

    /**
     * Creates the handler and links it with the given
     * game controller
     */
    public Handler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Start of turn")) {
            controller.startTurn();
        }
        if (evt.getPropertyName().equals("Player character defeated")) {
            controller.onPlayerCharacterDefeat((IPlayerCharacter) evt.getNewValue());
        }
        if (evt.getPropertyName().equals("Enemy defeated")) {
            controller.onEnemyDefeat((Enemy) evt.getNewValue());
        }

    }
}