package org.example.animal.enumAnimal;

import java.util.Random;

/**
 * Enum возможной породы хищного животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum BreedPredator {

    BREED_PREDATOR_1 ("Зубастый"),
    BREED_PREDATOR_2 ("Водоплавающий"),
    BREED_PREDATOR_3 ("Охотничий"),
    BREED_PREDATOR_4 ("Бегающий"),
    BREED_PREDATOR_5 ("Нападающий"),
    BREED_PREDATOR_6 ("Мирный");

    private final String title;

    BreedPredator(String title) {
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
     * Функция получения случайной породы хищного животного.
     * Возвращает случайную породу животного
     */
    public static String randomBreedPredator()  {
        BreedPredator[] breeds = values();
        return String.valueOf(breeds[BREED.nextInt(breeds.length)]);
    }
}