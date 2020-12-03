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

---

For this project, I've assumed that characters won't level up during a battle sequence. That is, their
attributes (HP, Strength, Defense, etc) will remain constant, so they can be used to generate hash keys
and to determine whether two characters are the same or not.

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

---

For this version of the project, a Thief can equip swords, knives and bows.