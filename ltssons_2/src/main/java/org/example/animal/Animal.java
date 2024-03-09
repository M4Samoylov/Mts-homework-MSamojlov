package org.example.animal;

import java.time.LocalDate;

/**
 * Интерфейс возможных методов для сущности Animal
 * @autor Самойлов Максим
 * @version 1.1
 */
public interface Animal {
    String getBreed();
    String getName();
    Double getCost();
    String getCharacter();
    LocalDate getBirthDate();
}