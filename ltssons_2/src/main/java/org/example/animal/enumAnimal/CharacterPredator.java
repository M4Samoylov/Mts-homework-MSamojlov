package org.example.animal.enumAnimal;

import java.util.Random;

public enum CharacterPredator {
    Злой, Агрессивный, Драчливый,
    Храбрый, Злючий, Тугой;

    private static final Random CHARACTER = new Random();

    public static String randomCharacterPredator()  {
        CharacterPredator[] characters = values();
        return String.valueOf(characters[CHARACTER.nextInt(characters.length)]);
    }
}