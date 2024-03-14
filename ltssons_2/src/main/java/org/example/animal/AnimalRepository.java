package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    default Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalException {
        return new HashMap<>();
    }

    default Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, int N) throws InvalidAnimalException {
        return new HashMap<>();
    }

    default Map<String, Integer> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException {
        return new HashMap<>();
    }
}