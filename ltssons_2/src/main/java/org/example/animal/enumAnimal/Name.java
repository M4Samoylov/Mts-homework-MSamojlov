package org.example.animal.enumAnimal;

import java.util.Random;

public enum Name {
    Василий, Мурка, Моська,
    Булка, Пушок, Тигр,
    Убийца, Злюка, Жестокий,
    Зубастик, Агрессор, Машина;

    private static final Random NAME = new Random();

    public static String randomName()  {
        Name[] names = values();
        return String.valueOf(names[NAME.nextInt(names.length)]);
    }
}