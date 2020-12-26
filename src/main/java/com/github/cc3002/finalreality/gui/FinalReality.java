package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.GameController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar
 */
public class FinalReality extends Application implements IGUI{

  GameController controller = new GameController();

  Group root = new Group();
  Group battleInfo = new Group();
  Group playerTurnScreen = new Group();
  Group inventory = new Group();
  Group damageInfo = new Group();

  private static final String RESOURCE_PATH = "src/main/resources/";
  ArrayList<String> knightNames = new ArrayList<>(Arrays.asList("Draug", "Dolph", "Macellan", "Roger", "?"));
  ArrayList<String> engineerNames = new ArrayList<>(Arrays.asList("Jake", "Beck", "Grigas", "Toras", "?"));
  ArrayList<String> thiefNames = new ArrayList<>(Arrays.asList("Julian", "Rickard", "Dahl", "Barm", "?"));
  ArrayList<String> bMageNames = new ArrayList<>(Arrays.asList("Merric", "Linde", "Arlen", "Jubelo", "?"));
  ArrayList<String> wMageNames = new ArrayList<>(Arrays.asList("Lena", "Maria", "Elice", "Wrys", "?"));

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(@NotNull Stage stage) throws FileNotFoundException {
    stage.setTitle("Final Reality");
    int width = 960;
    int height = 588;
    Scene scene = new Scene(root, width, height);
    var background =
        new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
    root.getChildren().add(background);

    controller.setGUI(this);
    controller.addEnemy("Bandit", 10, 4, 7, 9);
    setupInventory();

    root.getChildren().add(setupScreen());
    playerTurnScreen.getChildren().add(inventory);
    root.getChildren().add(playerTurnScreen);
    root.getChildren().add(battleInfo);
    root.getChildren().add(damageInfo);
    stage.setScene(scene);
    stage.show();
  }

  private Group setupScreen() throws FileNotFoundException {
    Group setupScr = new Group();
    var setupBack = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "box.png")));
    setupBack.setX(196);
    setupBack.setY(142);
    setupScr.getChildren().add(setupBack);

    Text PC_Text = new Text(250, 230, "Player Characters: 0");
    PC_Text.setFont(Font.font(30));
    PC_Text.setFill(Color.WHITE);
    setupScr.getChildren().add(PC_Text);

    Text enemyText = new Text(250, 350, "Enemies: 1");
    enemyText.setFont(Font.font(30));
    enemyText.setFill(Color.WHITE);
    setupScr.getChildren().add(enemyText);

    Text err_Text = new Text(500, 350, "");
    err_Text.setFont(Font.font(15));
    err_Text.setFill(Color.WHITE);
    setupScr.getChildren().add(err_Text);

    Button knightButton = new Button("Add Knight");
    knightButton.setLayoutX(250);
    knightButton.setLayoutY(250);
    knightButton.setOnAction((event -> {
      controller.addKnightWithSword(knightNames.get(controller.getAmountOfPlayerCharacters()),
              6, 5,
              "Iron sword", 6, 6);
      PC_Text.setText("Player Characters: " + controller.getAmountOfPlayerCharacters());
    }));
    setupScr.getChildren().add(knightButton);

    Button engButton = new Button("Add Engineer");
    engButton.setLayoutX(330);
    engButton.setLayoutY(250);
    engButton.setOnAction((event -> {
      controller.addEngineerWithAxe(engineerNames.get(controller.getAmountOfPlayerCharacters()),
              7, 4,
              "Iron axe", 7, 9);
      PC_Text.setText("Player Characters: " + controller.getAmountOfPlayerCharacters());
    }));
    setupScr.getChildren().add(engButton);

    Button thiefButton = new Button("Add Thief");
    thiefButton.setLayoutX(420);
    thiefButton.setLayoutY(250);
    thiefButton.setOnAction((event -> {
      controller.addThiefWithKnife(thiefNames.get(controller.getAmountOfPlayerCharacters()),
              8, 3,
              "Iron knife", 5, 3);
      PC_Text.setText("Player Characters: " + controller.getAmountOfPlayerCharacters());
    }));
    setupScr.getChildren().add(thiefButton);

    Button bMageButton = new Button("Add Black Mage");
    bMageButton.setLayoutX(490);
    bMageButton.setLayoutY(250);
    bMageButton.setOnAction((event -> {
      controller.addBlackMageWithStaff(bMageNames.get(controller.getAmountOfPlayerCharacters()),
              10, 2, 10,
              "Fire staff", 5, 3, 5);
      PC_Text.setText("Player Characters: " + controller.getAmountOfPlayerCharacters());
    }));
    setupScr.getChildren().add(bMageButton);

    Button wMageButton = new Button("Add White Mage");
    wMageButton.setLayoutX(600);
    wMageButton.setLayoutY(250);
    wMageButton.setOnAction((event -> {
      controller.addWhiteMageWithStaff(wMageNames.get(controller.getAmountOfPlayerCharacters()),
              12, 2, 10,
              "Wind staff", 6, 6, 6);
      PC_Text.setText("Player Characters: " + controller.getAmountOfPlayerCharacters());
    }));
    setupScr.getChildren().add(wMageButton);

    Button enemyButton = new Button("Add Enemy");
    enemyButton.setLayoutX(250);
    enemyButton.setLayoutY(360);
    enemyButton.setOnAction((event -> {
      int damage = ThreadLocalRandom.current().nextInt(6, 10);
      int weight = (damage - 4) * 3;
      controller.addEnemy("Bandit", 10, 4, damage, weight);
      enemyText.setText("Enemies: " + controller.getAmountOfEnemies());
    }));
    setupScr.getChildren().add(enemyButton);

    Button startButton = new Button("Start");
    startButton.setLayoutX(650);
    startButton.setLayoutY(360);
    startButton.setOnAction((event -> {
      if (controller.isPartyReady()) {
        controller.startGame();
        setupScr.getChildren().clear();
        updateInfo();
      } else {
        err_Text.setText("You need 4 characters in your party");
      }
    }));
    setupScr.getChildren().add(startButton);

    return setupScr;
  }

  private void setupInventory() {
    controller.addSword("Mercurius sword", 9, 15);
    controller.addAxe("Hauteclere axe", 10, 18);
    controller.addKnife("Kard knife", 7, 9);
    controller.addStaff("Starlight staff", 9, 15, 9);
    controller.addBow("Parthia bow", 8, 12);
  }

  @Override
  public void updateInfo() {
    battleInfo.getChildren().clear();
    try {
      battleInfo.getChildren().add(characterSprites());
      battleInfo.getChildren().add(characterHealth());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private Group characterSprites() throws FileNotFoundException {
    Group sprites = new Group();
    var playerCharAmount = controller.getAmountOfPlayerCharacters();
    for (int i=0; i<playerCharAmount; i++) {
      var IMAGE = controller.getPlayerCharacterSprite(i);
      var sprite = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + IMAGE)));
      sprite.setX(700 - 20*i); sprite.setY(315 - 26*playerCharAmount + 70*i);
      sprites.getChildren().add(sprite);
    }
    var enemyAmount = controller.getAmountOfEnemies();
    for (int i=0; i<enemyAmount; i++) {
      var sprite = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "Enemy.png")));
      sprite.setX(280 - 33*enemyAmount + 80*i); sprite.setY(310 - 16*enemyAmount + 40*i);
      sprites.getChildren().add(sprite);
    }
    return sprites;
  }

  private Group characterHealth() {
    Group hp = new Group();
    var playerCharAmount = controller.getAmountOfPlayerCharacters();
    for (int i=0; i<playerCharAmount; i++) {
      var CHAR_NAME = controller.getPlayerCharacterName(i);
      var CHAR_HP = controller.getPlayerCharacterHealth(i);
      var hpText = new Text(780, 600 - 25*playerCharAmount + 25*i, CHAR_NAME+": "+CHAR_HP+" HP");
      hpText.setFont(Font.font(25));
      hpText.setFill(Color.WHITE);
      hp.getChildren().add(hpText);
    }
    var enemyAmount = controller.getAmountOfEnemies();
    for (int i=0; i<enemyAmount; i++) {
      var CHAR_NAME = controller.getEnemyName(i);
      var CHAR_HP = controller.getEnemyHealth(i);
      var hpText = new Text(60, 600 - 25*enemyAmount + 25*i, CHAR_NAME+": "+CHAR_HP+" HP");
      hpText.setFont(Font.font(25));
      hpText.setFill(Color.WHITE);
      hp.getChildren().add(hpText);
    }
    return hp;
  }

  @Override
  public void updatePlayerTurnScreen() {
    // clearDamageText();
    playerTurnScreen.getChildren().clear();
    var enemyAmount = controller.getAmountOfEnemies();
    for (int i=0; i<enemyAmount; i++) {
      Button atkButton = new Button("Attack");
      atkButton.setLayoutX(5);
      atkButton.setLayoutY(578 - 25*enemyAmount + 25*i);
      int finalI = i;
      atkButton.setOnAction((event -> {
        playerTurnScreen.getChildren().clear();
        controller.activePlayerCharAttacksEnemy(finalI);
      }));
      playerTurnScreen.getChildren().add(atkButton);
    }
    var invText = new Text(780, 50, "Inventory");
    invText.setFont(Font.font(25));
    invText.setFill(Color.WHITE);
    playerTurnScreen.getChildren().add(invText);
    updateInventory();
    playerTurnScreen.getChildren().add(inventory);

    var PC_NAME = controller.getActivePlayerCharName();
    var pc_Text = new Text(15, 50, PC_NAME+"'s turn,");
    pc_Text.setFont(Font.font(35));
    pc_Text.setFill(Color.WHITE);
    playerTurnScreen.getChildren().add(pc_Text);

  }

  private void updateInventory() {
    inventory.getChildren().clear();
    for (int i=0; i<controller.getAmountOfWeapons(); i++) {
      Button weaponButton = new Button(controller.getWeaponName(i));
      weaponButton.setLayoutX(780);
      weaponButton.setLayoutY(60 + 25*i);
      int finalI = i;
      weaponButton.setOnAction((event -> {
        controller.activePlayerCharEquips(finalI);
        updateInventory();
      }));
      inventory.getChildren().add(weaponButton);
    }
    var WEAPON_DATA = controller.getActivePlayerCharWeaponData();
    var wp_Text = new Text(15, 85, WEAPON_DATA+" equipped.");
    wp_Text.setFont(Font.font(35));
    wp_Text.setFill(Color.WHITE);
    inventory.getChildren().add(wp_Text);

    var WEAPON_IMAGE = controller.getActivePlayerCharWeaponSprite();
    var playerIndex = controller.getActivePlayerCharIndex();
    var playerCharAmount = controller.getAmountOfPlayerCharacters();
    ImageView sprite = null;
    try {
      sprite = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + WEAPON_IMAGE)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    sprite.setX(658 - 20*playerIndex);
    sprite.setY(315 - 26*playerCharAmount + 70*playerIndex);
    inventory.getChildren().add(sprite);
  }

  @Override
  public void playerAttack(int enemyIndex, int enemyAmount, int dmgDealt) {
    clearDamageText();
    var setX = 300 - 33*enemyAmount + 80*enemyIndex;
    var setY = 330 - 16*enemyAmount + 40*enemyIndex;
    damageText(dmgDealt, setX, setY);
  }

  @Override
  public void enemyAttack(int partyIndex, int playerCharAmount, int dmgDealt) {
    // clearDamageText();
    var limitX = 760 - 20*partyIndex;
    var setX = ThreadLocalRandom.current().nextInt(limitX, 875);
    var setY = 350 - 26*playerCharAmount + 70*partyIndex;
    damageText(dmgDealt, setX, setY);
  }

  private void damageText(int dmgDealt, int setX, int setY) {
    var damageText = new Text(setX, setY, String.valueOf(-dmgDealt));
    damageText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    damageText.setFill(Color.RED);
    damageText.setStrokeWidth(2.5);
    damageText.setStroke(Color.BLACK);
    damageInfo.getChildren().add(damageText);
  }

  private void clearDamageText() {
/*    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
    damageInfo.getChildren().clear();
  }

  @Override
  public void gameWon() {
    endingMessage("You won!", 320, Color.WHITE, Color.BLACK);
  }

  @Override
  public void gameLost() {
    endingMessage("Game over", 300, Color.BLACK, Color.WHITE);
  }

  private void endingMessage(String text, int x, Color fill, Color stroke) {
    clearDamageText();
    playerTurnScreen.getChildren().clear();
    var endText = new Text(x, 300, text);
    endText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));
    endText.setFill(fill);
    endText.setStrokeWidth(2);
    endText.setStroke(stroke);
    root.getChildren().add(endText);
  }
}
