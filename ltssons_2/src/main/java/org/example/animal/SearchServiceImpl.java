package org.example.animal;

import org.example.animal.Exception.InvalidAnimalBirthDateException;
import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.time.Year;

public class SearchServiceImpl implements SearchService {

    @Override
    public Boolean checkLeapYearAnimal(AbstractAnimal abstractAnimal) throws InvalidAnimalException {
        if (abstractAnimal == null) {
            throw new InvalidAnimalException("На вход пришёл некорректный объект животного " + LocalDate.now());
        }

        if (abstractAnimal.getBirthDate() == null) {
            throw new InvalidAnimalBirthDateException("У животного " + abstractAnimal.getClass().getSimpleName().toUpperCase() +
                    " не указана дата его рождения");
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