package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.time.Year;

/**
 * Класс сервиса для проверки животного
 * @autor Самойлов Максим
 * @version 1.1
 */
public interface SearchService {

    /**
     * Функция проверяет год рождения животного - високосный или нет.
     * Выводит в консоль информацию - високосный год или нет + год его рождения
     */
    default Boolean checkLeapYearAnimal(AbstractAnimal abstractAnimal) throws InvalidAnimalException {
        if (abstractAnimal.getBirthDate() == null || abstractAnimal.getName() == null) {
            throw new InvalidAnimalException("На вход пришёл некорректный объект животного " + LocalDate.now());
        }

        boolean isLeap = Year.of(abstractAnimal.getBirthDate().getYear()).isLeap();
        if(isLeap) {
            System.out.println(abstractAnimal.getName().toUpperCase() +
                    " был рожден в високосный год, рожден в " +
                    abstractAnimal.getBirthDate().getYear());
        } else {
            System.out.println(abstractAnimal.getName().toUpperCase() +
                    " не был рожден в високосный год, рожден в " +
                    abstractAnimal.getBirthDate().getYear());
        }
        return isLeap;
    }
}