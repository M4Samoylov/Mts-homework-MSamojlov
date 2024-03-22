package org.example;

import org.example.animal.animalStructure.AbstractAnimal;
import org.example.animal.repository.impl.AnimalRepositoryImpl;
import org.example.animal.service.impl.CreateAnimalServiceImpl;
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