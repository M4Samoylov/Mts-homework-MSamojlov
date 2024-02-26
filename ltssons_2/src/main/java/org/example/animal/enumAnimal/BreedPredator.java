package org.example.animal.enumAnimal;

import java.util.Random;

public enum BreedPredator {
    Зубастый, Водоплавающий, Охотничий,
    Бегающий, Нападающий, Мирный;

    private static final Random BREED = new Random();

    public static String randomBreedPredator()  {
        BreedPredator[] breeds = values();
        return String.valueOf(breeds[BREED.nextInt(breeds.length)]);
    }
}