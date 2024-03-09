package org.example;

import org.example.animal.AbstractAnimal;
import org.example.animal.CreateAnimalServiceImpl;
import org.example.animal.Exception.InvalidAnimalBirthDateException;
import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.SearchServiceImpl;
import org.example.animal.enumAnimal.TypeAnimal;
import org.example.animal.pet.Pet;
import org.example.animal.predator.Predator;


public class HwExceptionJUnit {

    public static void main(String[] args) throws InvalidAnimalException {

        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        Pet pet = new Pet();
        Predator predator = new Predator();

        AbstractAnimal dog = createAnimalServiceImpl.createPetAnimal(pet, TypeAnimal.PET);

        try {
            searchServiceImpl.checkLeapYearAnimal(dog);
        }
        catch (InvalidAnimalBirthDateException | InvalidAnimalException ex) {
            try {
                throw new InvalidAnimalBirthDateException("У животного " + dog.getClass().getSimpleName().toUpperCase() +
                        " не указана дата его рождения");
            } catch (Exception exception) {
                throw new InvalidAnimalException(exception);
            }
        }
    }
}
