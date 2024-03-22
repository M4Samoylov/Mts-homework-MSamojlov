package org.example.animal.service;

import org.example.animal.animalStructure.AbstractAnimal;
import org.example.animal.Exception.InvalidAnimalException;

/**
 * Интерфейс сервиса для проверки животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public interface SearchService {

    /**
     * Функция проверяет год рождения животного - високосный или нет.
     * Выводит в консоль информацию - високосный год или нет + год его рождения
     */

    Boolean checkLeapYearAnimal(AbstractAnimal abstractAnimal) throws InvalidAnimalException;
}