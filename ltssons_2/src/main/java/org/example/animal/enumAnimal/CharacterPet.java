package org.example.animal.enumAnimal;

import java.util.Random;

public enum CharacterPet {
    Милый, Добрый, Ласковый,
    Любопытный, Домашний, Игривый;

    private static final Random CHARACTER = new Random();

    public static String randomCharacterPet()  {
        CharacterPet[] characters = values();
        return String.valueOf(characters[CHARACTER.nextInt(characters.length)]);
    }
}