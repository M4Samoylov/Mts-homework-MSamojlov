package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalException;

    Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, int N) throws InvalidAnimalException;

    Map<String, Integer> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException;
}