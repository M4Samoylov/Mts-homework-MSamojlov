package org.example.animal.enumAnimal;

import java.util.Random;

/**
 * Enum возможных характеров домашнего животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum CharacterPet {

    CHARACTER_PET_1 ("Милый"),
    CHARACTER_PET_2 ("Добрый"),
    CHARACTER_PET_3 ("Ласковый"),
    CHARACTER_PET_4 ("Любопытный"),
    CHARACTER_PET_5 ("Домашний"),
    CHARACTER_PET_6 ("Игривый");

    private final String title;

    CharacterPet(String title) {
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
     * Функция получения случайного характера домашнего животного.
     * Возвращает случайный характер животного
     */
    public static String randomCharacterPet()  {
        CharacterPet[] characters = values();
        return String.valueOf(characters[CHARACTER.nextInt(characters.length)]);
    }
}