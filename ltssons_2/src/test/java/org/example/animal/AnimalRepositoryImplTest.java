package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.pet.Cat;
import org.example.animal.pet.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {

    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    @ParameterizedTest
    @DisplayName("findLeapYearNames, Год високосный у переданного объекта, возвращается Map с одной записью, Позитивный тест")
    @ValueSource(ints = {2024, 2020, 2016, 2012, 2008})
    void checkLeapYearFindLeapYearNames(int year) throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Map<String, LocalDate> expected = new HashMap<>(Map.of(
                "Cat Мурка", LocalDate.of(year, 1, 1)));
        Cat cat = new Cat();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        animals.add(cat);

        assertEquals(expected, animalRepository.findLeapYearNames(animals));
    }

    @ParameterizedTest
    @DisplayName("findLeapYearNames, Год невисокосный у переданного объекта, возвращается пустая Map, Позитивный тест")
    @ValueSource(ints = {2023, 2022, 2021, 2019, 2018})
    void checkNoLeapYearFindLeapYearNames(int year) throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        animals.add(cat);

        Map<String, LocalDate> actual = animalRepository.findLeapYearNames(animals);

        assertTrue(actual.isEmpty());
    }

    @ParameterizedTest
    @DisplayName("findLeapYearNames, Год високосный у двух переданных объектов, возвращается Map с двумя записями, Позитивный тест")
    @ValueSource(ints = {2024, 2020, 2016, 2012, 2008})
    void checkLeapYearFindLeapYearNamesMultipleAnimal(int year) throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Map<String, LocalDate> expected = new HashMap<>(Map.of(
                "Cat Мурка", LocalDate.of(year, 1, 1),
                "Dog Мухтар", LocalDate.of(year, 1, 1)));
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(year, 1, 1));

        animals.add(cat);
        animals.add(dog);

        assertEquals(expected, animalRepository.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("findLeapYearNames, Год високосный у одного из переданных объектов, возвращается Map с одной записью, Позитивный тест")
    void checkNoLeapYearFindLeapYearNamesMultipleAnimal() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Map<String, LocalDate> expected = new HashMap<>(Map.of(
                "Dog Мухтар", LocalDate.of(2020, 1, 1)));
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2021, 1, 1));

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2020, 1, 1));

        animals.add(cat);
        animals.add(dog);

        assertEquals(expected, animalRepository.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("findOlderAnimal, 2 объекта в массиве - 1 проходит условие, возвращается Map с одной записью, Позитивный тест")
    void checkYearOldListOneEntryFindLeapYearNames() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        int year = 2000;

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(year - 5, 1, 1));
        animals.add(dog);

        Map<AbstractAnimal, Integer> expected = new HashMap<>(Map.of(
                dog, dog.getAge()));

        assertEquals(expected, animalRepository.findOlderAnimal(animals, dog.getAge() - 1));
    }

    @Test
    @DisplayName("findOlderAnimal, 2 объект в массиве - 2 проходит условие, возвращается Map с двумя записями, Позитивный тест")
    void checkYearOldListTwoEntryFindLeapYearNames() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        int year = 2000;

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(year - 5, 1, 1));
        animals.add(dog);

        Map<AbstractAnimal, Integer> expected = new HashMap<>(Map.of(
                cat, cat.getAge(),
                dog, dog.getAge()));

        assertEquals(expected, animalRepository.findOlderAnimal(animals, cat.getAge() - 1));
    }

    @Test
    @DisplayName("findOlderAnimal, 2 объект в массиве - 0 проходит условие, возвращается Map с одной записью (самое старое животное), Позитивный тест")
    void checkYearOldListMaxAgeFindLeapYearNames() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        int year = 2000;

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(year, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(year - 5, 1, 1));
        animals.add(dog);

        Map<AbstractAnimal, Integer> expected = new HashMap<>(Map.of(
                dog, dog.getAge()));

        assertEquals(expected, animalRepository.findOlderAnimal(animals, dog.getAge() + 1));
    }

    @Test
    @DisplayName("findDuplicate, 2 разных объект в массиве, возвращается Map с двумя записями, Позитивный тест")
    void checkMultipleAnimalFindDuplicate() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(dog);

        Map<String, Integer> expected = new HashMap<>(Map.of(
                Cat.class.getSimpleName(), 1,
                Dog.class.getSimpleName(), 1));

        assertEquals(expected, animalRepository.findDuplicate(animals));
    }

    @Test
    @DisplayName("findDuplicate, 2 объекта одинакового типа в массиве, возвращается Map с одной записью, Позитивный тест")
    void checkOneTypeAnimalFindDuplicate() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        cat.setBreed("Длинношёрстная");
        cat.setName("Кузя");
        cat.setCost(14.1);
        cat.setCharacter("Хитрый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        Map<String, Integer> expected = new HashMap<>(Map.of(
                Cat.class.getSimpleName(), 2));

        assertEquals(expected, animalRepository.findDuplicate(animals));
    }

    @Test
    @DisplayName("findLeapYearNames, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindLeapYearNames() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findLeapYearNames(null));
    }

    @Test
    @DisplayName("findOlderAnimal, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindOlderAnimal() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findOlderAnimal(null, 1));
    }

    @Test
    @DisplayName("findDuplicate, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindDuplicate() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findDuplicate(null));
    }
}