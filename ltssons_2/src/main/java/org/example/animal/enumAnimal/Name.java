package org.example.animal.enumAnimal;

import java.util.Random;

/**
 * Enum возможных имён для животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum Name {

    NAME_1 ("Василий"),
    NAME_2 ("Мурка"),
    NAME_3 ("Моська"),
    NAME_4 ("Булка"),
    NAME_5 ("Пушок"),
    NAME_6 ("Тигр"),
    NAME_7 ("Убийца"),
    NAME_8 ("Злюка"),
    NAME_9 ("Жестокий"),
    NAME_10 ("Зубастик"),
    NAME_11 ("Агрессор"),
    NAME_12 ("Машина");

    private final String title;

    Name(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    private static final Random NAME = new Random();

    /**
     * Функция получения случайного name животного.
     * Возвращает случайное имя животного
     */
    public static String randomName()  {
        Name[] names = values();
        return String.valueOf(names[NAME.nextInt(names.length)]);
    }
}