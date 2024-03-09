package org.example.animal.enumAnimal;

/**
 * Enum возможных типов животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public enum TypeAnimal {
    PET ("Домашний"),
    PREDATOR("Хищник");

    private final String title;

    TypeAnimal(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}