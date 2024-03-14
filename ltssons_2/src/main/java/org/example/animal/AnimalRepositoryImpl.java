package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.pet.Cat;
import org.example.animal.pet.Dog;
import org.example.animal.predator.Fox;
import org.example.animal.predator.Shark;
import org.example.animal.predator.Wolf;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс сервиса для HW-6
 *
 * @version 1.1
 * @autor Самойлов Максим
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    /**
     * Функция для формирования Map животных рождённых в високосный год.
     * @return Map<String, LocalDate>
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        Map<String, LocalDate> result = new HashMap<>();

        for (AbstractAnimal animal : animals) {
            if (searchServiceImpl.checkLeapYearAnimal(animal)) {
                result.put(animal.getClass().getSimpleName() + " " + animal.getName(), animal.getBirthDate());
            }
        }
        return result;
    }

    /**
     * Функция для формирования Map содержащим животных возраст которых > N.
     * Если нет подходящих под условие животных -> в Map будет содержать самое старое животное
     * @return Map<AbstractAnimal, Integer>
     */
    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, int N) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        Map<AbstractAnimal, Integer> result = new HashMap<>();

        for (AbstractAnimal animal : animals) {
            int age = animal.getAge();
            if (age > N) {
                result.put(animal, age);
            }
        }


        if (result.isEmpty()) {
            AbstractAnimal maxAgeAnimal = null;
            for (AbstractAnimal animal : animals) {
                if (maxAgeAnimal == null) {
                    maxAgeAnimal = animal;
                } else {
                    int age = animal.getAge();
                    int maxAge = maxAgeAnimal.getAge();
                    if (age > maxAge) {
                        maxAgeAnimal = animal;
                    }
                }
            }

            assert maxAgeAnimal != null;
            result.put(maxAgeAnimal, maxAgeAnimal.getAge());
        }

        return result;
    }

    /**
     * Функция для формирования Map содержащим перечисления ключ - Тип животного, значение - количество дубликатов.
     * @return Map<AbstractAnimal, Integer>
     */
    @Override
    public Map<String, Integer> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        Map<String, Integer> result = new HashMap<>();

        int catCount = 0;
        int dogCount = 0;
        int foxCount = 0;
        int sharkCount = 0;
        int wolfCount = 0;

        for (AbstractAnimal animal : animals) {
            if (animal instanceof Cat) {
                catCount++;
            } else if (animal instanceof Dog) {
                dogCount++;
            } else if (animal instanceof Fox) {
                foxCount++;
            } else if (animal instanceof Shark) {
                sharkCount++;
            } else if (animal instanceof Wolf) {
                wolfCount++;
            }
        }

        if (catCount != 0) {
            result.put(Cat.class.getSimpleName(), catCount);
        }
        if (dogCount != 0) {
            result.put(Dog.class.getSimpleName(), dogCount);
        }
        if (foxCount != 0) {
            result.put(Fox.class.getSimpleName(), foxCount);
        }
        if (sharkCount != 0) {
            result.put(Shark.class.getSimpleName(), sharkCount);
        }
        if (wolfCount != 0) {
            result.put(Wolf.class.getSimpleName(), wolfCount);
        }

        System.out.println(result);
        return result;
    }
}