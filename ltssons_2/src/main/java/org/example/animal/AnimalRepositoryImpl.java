package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;

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
     *
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
     *
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
     *
     * @return Map<AbstractAnimal, Integer>
     */
    @Override
    public Map<String, Integer> findDuplicate(List<AbstractAnimal> animals) throws InvalidAnimalException {
        if (animals == null) {
            throw new InvalidAnimalException("На вход пришёл пустой List animals");
        }

        Map<String, Integer> result = new HashMap<>();

        for (AbstractAnimal animal : animals) {
            String name = animal.getClass().getSimpleName();
            if (!result.containsKey(name)) {
                result.put(name, 1);
            } else {
                int value = result.get(name);
                result.replace(name, value, value + 1);
            }
        }

        System.out.println(result);
        return result;
    }
}