package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.gui.nodes.MovableNodeBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Alfredo Escobar
 */
public class FinalReality extends Application {

  private static final String RESOURCE_PATH = "src/main/resources/";
  GameController controller = new GameController();
  int playerCharacterAmount = 0;
  Integer enemyAmount = 0;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(@NotNull Stage stage) throws FileNotFoundException {
    stage.setTitle("Final Reality");
    Group root = new Group();
    int width = 960;
    int height = 588;
    Scene scene = new Scene(root, width, height);
    var sprite = new MovableNodeBuilder(scene).setImagePath(RESOURCE_PATH + "sprite.png")
                                              .setPosition(100, 100)
                                              .setSize(50, 50)
                                              .build();
    var background =
        new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
    root.getChildren().add(background);
    //root.getChildren().add(sprite.getNode());
    root.getChildren().add(setupScreen());
    //root.getChildren().add(setupButton());
    stage.setScene(scene);
    stage.show();
  }

  private Group setupScreen() throws FileNotFoundException {
    Group setupScr = new Group();
    var setupBack = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "box.png")));
    setupBack.setX(196);
    setupBack.setY(142);
    setupScr.getChildren().add(setupBack);

    Text PC_Text = new Text(250, 230, "Player Characters: 0"); PC_Text.setFont(Font.font(30));
    PC_Text.setFill(Color.WHITE);
    setupScr.getChildren().add(PC_Text);

    Button knightButton = new Button("Add Knight"); knightButton.setLayoutX(250); knightButton.setLayoutY(250);
    setupScr.getChildren().add(knightButton);
    Button engButton = new Button("Add Engineer"); engButton.setLayoutX(330); engButton.setLayoutY(250);
    setupScr.getChildren().add(engButton);
    Button thiefButton = new Button("Add Thief"); thiefButton.setLayoutX(420); thiefButton.setLayoutY(250);
    setupScr.getChildren().add(thiefButton);
    Button bMageButton = new Button("Add Black Mage"); bMageButton.setLayoutX(490); bMageButton.setLayoutY(250);
    setupScr.getChildren().add(bMageButton);
    Button wMageButton = new Button("Add White Mage"); wMageButton.setLayoutX(600); wMageButton.setLayoutY(250);
    setupScr.getChildren().add(wMageButton);

    Text enemyText = new Text(250, 350, "Enemies: 0"); enemyText.setFont(Font.font(30));
    enemyText.setFill(Color.WHITE);
    setupScr.getChildren().add(enemyText);
    Button enemyButton = new Button("Add Enemy"); enemyButton.setLayoutX(250); enemyButton.setLayoutY(360);
    enemyButton.setOnAction((event -> {enemyAmount += 1; enemyText.setText("Enemies: "+enemyAmount.toString());}));
    setupScr.getChildren().add(enemyButton);

    Button startButton = new Button("Start"); startButton.setLayoutX(650); startButton.setLayoutY(360);
    setupScr.getChildren().add(startButton);

    return setupScr;
  }

  private void addPlayerCharacter() {


  }

  private @NotNull Button setupButton() {
    Button button = new Button("Play sound");
    button.setLayoutX(500);
    button.setLayoutY(500);
    button.setFocusTraversable(false);
    button.setOnAction(FinalReality::playSound);
    return button;
  }

  private static void playSound(ActionEvent event) {
    String audioFilePath = RESOURCE_PATH + "prfvr.wav";
    try {
      Clip sound = AudioSystem.getClip();
      try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
          new File(audioFilePath))) {
        sound.open(audioInputStream);
        sound.start();
      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }
}
