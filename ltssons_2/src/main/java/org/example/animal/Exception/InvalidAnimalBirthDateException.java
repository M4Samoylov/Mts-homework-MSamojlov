package org.example.animal.Exception;

/**
 * Класс для кастомной InvalidAnimalBirthDateException unchecked ошибки
 * @autor Самойлов Максим
 * @version 1.1
 */
public class InvalidAnimalBirthDateException extends RuntimeException{

    public InvalidAnimalBirthDateException(String message) {
        super(message);
    }
}