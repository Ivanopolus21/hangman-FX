module cz.cvut.fel.pjv.hangman.hangmanfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.cvut.fel.pjv.hangman.hangmanfx to javafx.fxml;
    exports cz.cvut.fel.pjv.hangman.hangmanfx;
}