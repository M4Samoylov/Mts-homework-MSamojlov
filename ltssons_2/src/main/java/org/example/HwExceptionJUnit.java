package org.example;

import org.example.animal.animalStructure.AbstractAnimal;
import org.example.animal.service.impl.CreateAnimalServiceImpl;
import org.example.animal.Exception.InvalidAnimalBirthDateException;
import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.service.impl.SearchServiceImpl;
import org.example.animal.enumAnimal.TypeAnimal;
import org.example.animal.animalStructure.pet.Pet;
import org.example.animal.animalStructure.predator.Predator;


public class HwExceptionJUnit {

    public static void main(String[] args) throws InvalidAnimalException {

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        Pet pet = new Pet();
        Predator predator = new Predator();

        AbstractAnimal dog = createAnimalServiceImpl.createPetAnimal(pet, TypeAnimal.PET);

        try {
            searchServiceImpl.checkLeapYearAnimal(dog);
        } catch (InvalidAnimalBirthDateException ex) {
            throw new InvalidAnimalException(ex);
        }
    }
}
