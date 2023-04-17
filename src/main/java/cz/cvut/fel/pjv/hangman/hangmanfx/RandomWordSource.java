package cz.cvut.fel.pjv.hangman.hangmanfx;

import java.util.Random;

public class RandomWordSource implements WordSource{
    private final String[] HIDDEN_WORDS = {
            "GHOST", "FLOWER", "BANANA", "SNOWFLAKE", "BOOK", "SNAKE", "LIGHT",
            "TREE", "LIPS", "APPLE", "SLIDE", "SOCKS", "SMILE", "SWING", "COAT",
            "SHOE", "WATER", "HEART", "OCEAN", "KITE", "MOUTH", "MILK", "DUCK",
            "EYES", "SKATEBOARD", "BIRD", "APPLE", "PERSON", "GIRL", "MOUSE",
            "BALL", "HOUSE", "STAR", "NOSE", "WHALE", "JACKET", "SHIRT", "HIPPO",
            "BEACH", "FACE", "COOKIE", "CHEESE", "DRUM", "CIRCLE", "SPOON", "WORM"
    };
    @Override
    public String getWord(){
        return HIDDEN_WORDS[new Random().nextInt(HIDDEN_WORDS.length)];
    }
}
