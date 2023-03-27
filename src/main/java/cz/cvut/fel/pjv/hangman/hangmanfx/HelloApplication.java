package cz.cvut.fel.pjv.hangman.hangmanfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventListener;
import java.util.Random;

public class HelloApplication extends Application {
    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String[] HIDDEN_WORDS = {
            "GHOST", "FLOWER", "BANANA", "SNOWFLAKE", "BOOK", "SNAKE", "LIGHT",
            "TREE", "LIPS", "APPLE", "SLIDE", "SOCKS", "SMILE", "SWING", "COAT",
            "SHOE", "WATER", "HEART", "OCEAN", "KITE", "MOUTH", "MILK", "DUCK",
            "EYES", "SKATEBOARD", "BIRD", "APPLE", "PERSON", "GIRL", "MOUSE",
            "BALL", "HOUSE", "STAR", "NOSE", "WHALE", "JACKET", "SHIRT", "HIPPO",
            "BEACH", "FACE", "COOKIE", "CHEESE", "DRUM", "CIRCLE", "SPOON", "WORM"
    };
    private final int MAX_MISS = 6;

    private ImageView hangmanImage = new ImageView();
    private int missCount = 0;
    private String hiddenWord;
    private String guessedWord;
    @Override
    public void start(Stage stage) throws IOException {
        createHiddenWord();
        //Upper
        updateImageLabel();
        Pane upperPane = new BorderPane(hangmanImage);
        upperPane.setPadding(new Insets(15));
//        upperPane.setStyle("-fx-background-color: 'green';");
        //Middle
        initGuessedWord();
        Label guessedWordLabel = new Label(guessedWord);
        guessedWordLabel.setStyle("-fx-font-size: 50");
        Pane middlePane = new BorderPane(guessedWordLabel);
//        middlePane.setStyle("-fx-background-color: 'cyan';");
        //Bottom
        Pane bottomPane = new FlowPane();
        for (char c : LETTERS.toCharArray()){
            Button letterButton = new Button(String.valueOf(c));
            letterButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    letterButton.setDisable(true);
                    //  TODO!!!!
                }
            });
            bottomPane.getChildren().add(letterButton);
        }
//        bottomPane.setStyle("-fx-background-color: 'orange';");
        //Scene
        VBox root = new VBox(upperPane, middlePane, bottomPane);
        Scene scene = new Scene(root);
        stage.setTitle("Hangman");
        stage.setScene(scene);
        stage.show();
    }
    private void createHiddenWord(){
        hiddenWord = HIDDEN_WORDS[new Random().nextInt(HIDDEN_WORDS.length)];
    }
    private void updateImageLabel() {
        try {
            Image image = new Image("hangman_" + missCount + ".png");
            hangmanImage.setImage(image);
        } catch (IllegalArgumentException ex) {
            System.err.println("Can't load resource: " + ex.getMessage());
        }
    }
    private void initGuessedWord(){
        guessedWord = "_".repeat(hiddenWord.length());
    }
    public static void main(String[] args) {
        launch();
    }
}