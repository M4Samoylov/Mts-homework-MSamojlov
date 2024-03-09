package org.example.animal.Exception;

/**
 * Класс для кастомной InvalidAnimalException checked ошибки
 * @autor Самойлов Максим
 * @version 1.1
 */
public class InvalidAnimalException extends Exception{

    private static final String ERROR_MESSAGE = "Работа метода завершилась ошибкой";
    public InvalidAnimalException(Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }

    public InvalidAnimalException(String message) {
        super(message);
    }
}