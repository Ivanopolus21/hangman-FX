package cz.cvut.fel.pjv.hangman.hangmanfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {
    @Test
    void initGuessedWord(){
        Model sut = new Model();
        String expectedResult = ".PP..";
        sut.createHiddenWord(new MockWordSource());
        sut.initGuessedWord();
        sut.updateGuessedWord('P');
        assertEquals(expectedResult, sut.getGuessedWord());
    }
    @Test
    void updateGuessedWord(){
        Model sut = new Model();
        String expectedResult = ".PP..";
        sut.createHiddenWord(new MockWordSource());
        sut.initGuessedWord();
        sut.updateGuessedWord('P');
        assertEquals(expectedResult, sut.getGuessedWord());
    }

    @Test
    void isWin(){
        Model sut = new Model();
        boolean expectedResult = true;
        sut.createHiddenWord(new MockWordSource());
        sut.initGuessedWord();
        sut.updateGuessedWord('P');
        sut.updateGuessedWord('A');
        sut.updateGuessedWord('L');
        sut.updateGuessedWord('E');
        assertEquals(expectedResult, sut.isWin());
    }

    void isLost(){
        Model sut = new Model();
        boolean expectedResult = true;
        sut.createHiddenWord(new MockWordSource());
        sut.initGuessedWord();
        for (int i = 0; i < 6; i++){
            sut.updateGuessedWord(Model.LETTERS.charAt(i));
        }
        assertEquals(expectedResult, sut.isLost());
    }
}
