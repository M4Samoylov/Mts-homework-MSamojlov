package org.example;

import org.example.animal.AbstractAnimal;
import org.example.animal.AnimalRepositoryImpl;
import org.example.animal.CreateAnimalServiceImpl;
import org.example.animal.Exception.InvalidAnimalException;

import java.util.List;

public class HwCollections {

    public static void main(String[] args) throws InvalidAnimalException {

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

        List<AbstractAnimal> animals = createAnimalServiceImpl.createListAnimals(20);

        animalRepository.findLeapYearNames(animals);
        animalRepository.findOlderAnimal(animals, 10);
        animalRepository.findDuplicate(animals);
        animalRepository.findOldAndExpensive(animals);

    }
}