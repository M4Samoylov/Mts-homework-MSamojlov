package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface AnimalRepository {

    default Map<String, LocalDate> findLeapYearNames(ArrayList<AbstractAnimal> animals) throws InvalidAnimalException {
        return new HashMap<String, LocalDate>();
    }

    default void findOlderAnimal() {

    }

    default void findDuplicate() {

    }
}