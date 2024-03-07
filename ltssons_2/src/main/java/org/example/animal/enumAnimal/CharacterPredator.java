package org.example.animal.enumAnimal;

import java.util.Random;

/**
 * Enum возможных характеров хищного животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum CharacterPredator {

    CHARACTER_PREDATOR_1 ("Злой"),
    CHARACTER_PREDATOR_2 ("Агрессивный"),
    CHARACTER_PREDATOR_3 ("Драчливый"),
    CHARACTER_PREDATOR_4 ("Храбрый"),
    CHARACTER_PREDATOR_5 ("Злючий"),
    CHARACTER_PREDATOR_6 ("Тугой");

    private final String title;

    CharacterPredator(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    private static final Random CHARACTER = new Random();

    /**
     * Функция получения случайного характера хищного животного.
     * Возвращает случайный характер животного
     */
    public static String randomCharacterPredator()  {
        CharacterPredator[] characters = values();
        return String.valueOf(characters[CHARACTER.nextInt(characters.length)]);
    }
}