package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.cc3002.finalreality.model.AbstractSetUp;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

class WeaponTest extends AbstractSetUp {

  @BeforeEach
  void setUp() {
    super.setUpTurns();
    super.setUpWeapons();
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, MAGIC_DAMAGE);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }

  @Test
  void WeaponEqualBranching() {
    var differentNameAxe = new Axe("Hauteclere", DAMAGE, WEIGHT);
    var differentDamageAxe = new Axe(AXE_NAME, 13, WEIGHT);
    var differentSpeedAxe = new Axe(AXE_NAME, DAMAGE, 8);
    var testKnight = new Knight("Jagen", turns, 5, 18);

    assertEquals(testAxe, testAxe);
    assertNotEquals(testKnight, testAxe);
    assertNotEquals(differentNameAxe, testAxe);
    assertNotEquals(differentDamageAxe, testAxe);
    assertNotEquals(differentSpeedAxe, testAxe);
    assertNotEquals(testSword, testAxe);
  }

  @Test
  void StaffEqualBranching() {
    var differentNameStaff = new Staff("Wooden Staff", DAMAGE, WEIGHT, MAGIC_DAMAGE);
    var differentDamageStaff = new Staff(STAFF_NAME, 13, WEIGHT, MAGIC_DAMAGE);
    var differentSpeedStaff = new Staff(STAFF_NAME, DAMAGE, 8, MAGIC_DAMAGE);
    var differentMagDamageStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, 10);

    assertNotEquals(differentNameStaff, testStaff);
    assertNotEquals(differentDamageStaff, testStaff);
    assertNotEquals(differentSpeedStaff, testStaff);
    assertNotEquals(differentMagDamageStaff, testStaff);
    assertNotEquals(testSword, testStaff);
  }

  @Test
  void staffMagicDamageTest() {
    Staff testStaff2 = new Staff("Wooden Staff", DAMAGE, WEIGHT, MAGIC_DAMAGE_2);
    assertEquals(MAGIC_DAMAGE_2, testStaff2.getMagicDamage());
  }
}