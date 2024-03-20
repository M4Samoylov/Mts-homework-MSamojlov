package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalException;

    Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, int N) throws InvalidAnimalException;

    Map<String, List<AbstractAnimal>> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException;

    double findAverageAge(List<AbstractAnimal> animals) throws InvalidAnimalException;

    List<AbstractAnimal> findOldAndExpensive(List<AbstractAnimal> animals) throws InvalidAnimalException;

    List<String> findMinConstAnimals(List<AbstractAnimal> animals) throws InvalidAnimalException;
}