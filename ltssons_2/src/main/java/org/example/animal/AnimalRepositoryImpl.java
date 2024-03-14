package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnimalRepositoryImpl implements AnimalRepository {
    @Override
    public Map<String, LocalDate> findLeapYearNames(ArrayList<AbstractAnimal> animals) throws InvalidAnimalException {
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        Map<String, LocalDate> leapYearAnimal = new HashMap<String, LocalDate>();

        for (AbstractAnimal animal : animals) {
            searchServiceImpl.checkLeapYearAnimal(animal);
            leapYearAnimal.put(animal.getClass().getSimpleName().toUpperCase() +
                            " " + animal.getName(),
                    animal.getBirthDate());
        }
        return leapYearAnimal;
    }
}