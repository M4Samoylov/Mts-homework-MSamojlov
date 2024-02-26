package org.example.animal.enumAnimal;

import java.util.Random;

public enum BreedPet {
    Хвостатый, Носатый, Прямоходящий,
    Плавающий, Шерстяной, Бархатный;

    private static final Random BREED = new Random();

    public static String randomBreedPet()  {
        BreedPet[] breeds = values();
        return String.valueOf(breeds[BREED.nextInt(breeds.length)]);
    }
}