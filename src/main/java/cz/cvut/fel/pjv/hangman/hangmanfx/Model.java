package cz.cvut.fel.pjv.hangman.hangmanfx;

import java.util.Random;

public class Model {
    public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int MAX_MISS = 6;
    private int missCount = 0;
    private static String hiddenWord;
    private static String guessedWord;

    public int getMissCount() {
        return missCount;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public boolean isLost(){
        return missCount >= 6;
    }

    public boolean isWin(){
        return true;
    }

    public void createHiddenWord(RandomWordSource wordSource){
        hiddenWord = wordSource.getWord();
    }
    public static void initGuessedWord(){
        guessedWord = "_".repeat(hiddenWord.length());
    }

    public boolean updateGuessedWord(char c){
        String newGuessedWord = new String();
        boolean rightChar = false;
        for (int i = 0; i < hiddenWord.length(); i++){
            if (hiddenWord.charAt(i) == c){
                newGuessedWord += c;
                rightChar = true;
            } else {
                newGuessedWord += guessedWord.charAt(i);
            }

        }
        if (rightChar == false) {
            missCount += 1;
        }
        guessedWord = newGuessedWord;
        return rightChar;
    }
}
