Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

The Game
---
Before you start the game, you will need to select 4 playable characters to use during the game.
Their stats are pre-determined. You can also raise the amount of enemies your characters are going
to fight. Some of their stats are chosen at random.

After starting the game, you will notice two sets of characters: to the right, you have your playable
characters, and in the left you will notice the enemies. There are also two text lists at the bottom
of the screen. These indicate the Health Points of the characters.

During your turn, at the top of the screen you will see the name of the current active player
character, along with the name and damage points of their weapon. In the top-right corner, you will
see your inventory; it comes pre-loaded with 5 different weapons. If you click one of those weapons,
and the weapon type is compatible with the active character, they will equip the weapon, and leave
their previous weapon in the inventory. During your turn, you can equip weapons as many times as you
wish.

In the bottom-left corner, you will find Attack buttons, corresponding to each of the enemy
characters. Press one of them to attack. You can only attack once per turn.

The game ends when you defeat every enemy, or when the enemies defeat all your characters.

The Model
---

First, an abstract class (AbstractCharacter) has been defined in order to collect the common elements
of all characters (either controlled by the player or the CPU).

Then, we want to separate the behaviours inherent to the playable characters from those corresponding
to non-playable characters. So, the abstract class PlayerCharacter and the public class Enemy are defined
to satisfy the respective needs.

Next, classes for all the "common" types of playable characters (those who can't use magic) extend the
PlayableCharacter class. For the magical units, an abstract class has been created (AbstractMage), so
that the classes corresponding to specific magical units can extend this abstract class and get their
"mana" attributes.

Finally, for the weapons, we have the abstract class Weapon that defines shared attributes such as name,
damage and weight. For each specific type of weapon, a public class that extends Weapon has been defined.
The Staff weapons take advantage of this, as they can now have their own magicDamage attribute.

For this project, I've assumed that characters won't level up during a battle sequence. That is, their
attributes (HP, Strength, Defense, etc) will remain constant, so they can be used to generate hash keys
and to determine whether two characters are the same or not.

For this version of the project, a Thief can equip swords, knives and bows.

The Controller
---

The GameController class manages the flow of the game by communicating with the Model's classes and their
methods. In order to achieve this, eight game States (or phases) have been defined:

* Preparing Party: When the 4 player characters have not been created yet.
* Party Ready: When the 4 player characters have been created. From this state, the game can be initiated.
* Selecting First In Queue: When the game is waiting for a character to appear in the turns queue.
* Player Turn: When the game is waiting for the player to attack an enemy. From this state, the player
can execute the weapon equipping methods.
* Enemy Turn: From this state, the controller can execute the methods that allow the enemies to attack
the player characters.
* End Of Turn: The state where the character that just attacked gets removed and reincorporated to the end
of the waiting queue.
* Battle Lost: The state active after the player has lost the game.
* Battle Won: The state active after the player has won the game.

The View
---
The FinalReality class communicated with the Controller in order to visually represent the battle and to
read user inputs. The Scene Graph is composed of:
* Root: the main node.
    * Setup Screen: the screen that allows the user to create characters:
        * The buttons for creating characters
        * The buttons for starting the game
    * Battle Info: the node that contains the elements that will be shown during the entirety of the
    battle:
        * The character sprites
        * The character health lists
    * Player Turn Screen: the node that contains the elements that will be shown during the player
    character's turns:
        * The attack buttons
        * The Inventory
            * Its buttons
        * The equipped weapon sprite
        * The equipped weapon information
    * Damage Info: the red texts that indicate the damage taken by the characters.
    * End Text: the "You won!" or "Game over" message.