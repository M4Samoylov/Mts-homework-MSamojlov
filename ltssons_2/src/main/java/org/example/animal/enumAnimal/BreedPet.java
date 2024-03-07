package org.example.animal.enumAnimal;

import java.util.Random;

/**
 * Enum возможной породы домашнего животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum BreedPet {

    BREED_PET_1 ("Хвостатый"),
    BREED_PET_2 ("Носатый"),
    BREED_PET_3 ("Прямоходящий"),
    BREED_PET_4 ("Плавающий"),
    BREED_PET_5 ("Шерстяной"),
    BREED_PET_6 ("Бархатный");

    private final String title;

    BreedPet(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return getTitle();
    }

    private static final Random BREED = new Random();

    /**
     * Функция получения случайной породы домашнего животного.
     * Возвращает случайную породу животного
     */
    public static String randomBreedPet()  {
        BreedPet[] breeds = values();
        return String.valueOf(breeds[BREED.nextInt(breeds.length)]);
    }
}