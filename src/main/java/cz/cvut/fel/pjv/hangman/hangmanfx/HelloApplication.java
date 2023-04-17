package cz.cvut.fel.pjv.hangman.hangmanfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Model model = new Model();

    private ImageView hangmanImage = new ImageView();

    @Override
    public void start(Stage stage) throws IOException {
        model.createHiddenWord(new RandomWordSource());
        //Upper
        updateImageLabel();
        Pane upperPane = new BorderPane(hangmanImage);
        upperPane.setPadding(new Insets(15));
//        upperPane.setStyle("-fx-background-color: 'green';");
        //Middle
        Model.initGuessedWord();
        Label guessedWordLabel = new Label(model.getGuessedWord());
        guessedWordLabel.setStyle("-fx-font-size: 50");
        Pane middlePane = new BorderPane(guessedWordLabel);
//        middlePane.setStyle("-fx-background-color: 'cyan';");
        //Bottom
        Pane bottomPane = new FlowPane();
        for (char c : Model.LETTERS.toCharArray()){
            Button letterButton = new Button(String.valueOf(c));
            letterButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    letterButton.setDisable(true);
                    if (!model.updateGuessedWord(c)){
                        updateImageLabel();
                        if (model.isLost()){
                            Alert loseDialog = new Alert(Alert.AlertType.INFORMATION);
                            loseDialog.setTitle("Fail!");
                            loseDialog.setContentText("You lost!");
                            loseDialog.show();
                        }
                    } else {
                        guessedWordLabel.setText(model.getGuessedWord());
                        if (model.getGuessedWord().equals(model.getHiddenWord())){
                            Alert winDialog = new Alert(Alert.AlertType.INFORMATION);
                            winDialog.setTitle("Success!");
                            winDialog.setContentText("You won");
                            winDialog.showAndWait();
                        }
                    }
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

    private void updateImageLabel() {
        try {
            Image image = new Image("hangman_" + model.getMissCount() + ".png");
            hangmanImage.setImage(image);
        } catch (IllegalArgumentException ex) {
            System.err.println("Can't load resource: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        launch();
    }
}