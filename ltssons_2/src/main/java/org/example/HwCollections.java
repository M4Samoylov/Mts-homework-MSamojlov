package org.example;

import org.example.animal.Animal;
import org.example.animal.AnimalRepositoryImpl;
import org.example.animal.CreateAnimalServiceImpl;
import org.example.animal.Exception.InvalidAnimalException;

import java.util.List;
import java.util.Map;

public class HwCollections {

    public static void main(String[] args) throws InvalidAnimalException {

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

        Map<String, List<Animal>> animals = createAnimalServiceImpl.createMapAnimals(4);
//        animalRepository.findLeapYearNames(animals.get());

    }
}