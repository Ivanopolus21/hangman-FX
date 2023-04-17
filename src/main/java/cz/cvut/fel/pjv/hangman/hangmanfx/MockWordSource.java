package cz.cvut.fel.pjv.hangman.hangmanfx;

public class MockWordSource implements WordSource{

    @Override
    public String getWord() {
        return "APPLE";
    }
}
