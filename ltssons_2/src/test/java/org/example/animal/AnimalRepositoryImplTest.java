package org.example.animal;

import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.pet.Cat;
import org.example.animal.pet.Dog;
import org.example.animal.predator.Fox;
import org.example.animal.predator.Shark;
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

        List<AbstractAnimal> cats = new ArrayList<>();
        cats.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(12.5);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(dog);

        List<AbstractAnimal> dogs = new ArrayList<>();
        dogs.add(dog);

        Map<String, List<AbstractAnimal>> expected = new HashMap<>(Map.of(
                Cat.class.getSimpleName(), cats,
                Dog.class.getSimpleName(), dogs));

        assertEquals(expected, animalRepository.findDuplicate(animals));
    }

    @Test
    @DisplayName("findDuplicate, 2 объекта одинакового типа в массиве, возвращается Map с одной записью, Позитивный тест")
    void checkOneTypeAnimalFindDuplicate() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        List<AbstractAnimal> cats = new ArrayList<>();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(12.5);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);
        cats.add(cat);

        cat.setBreed("Длинношёрстная");
        cat.setName("Кузя");
        cat.setCost(14.1);
        cat.setCharacter("Хитрый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        cats.add(cat);

        Map<String, List<AbstractAnimal>> expected = new HashMap<>(Map.of(
                Cat.class.getSimpleName(), cats));

        assertEquals(expected, animalRepository.findDuplicate(animals));
    }

    @Test
    @DisplayName("findAverageAge, передаётся List из 2 объектов - , Позитивный тест")
    void checkFindAverageAge() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(10.0);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(20.0);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2005, 1, 1));
        animals.add(dog);

        double expected = (double) (cat.getAge() + dog.getAge()) / 2;

        assertEquals(expected, animalRepository.findAverageAge(animals));
    }

    @Test
    @DisplayName("findOldAndExpensive, передаётся List из 2 объектов, возвращается List с 1 записью, Фильтр по цене, Позитивный тест")
    void checkFindOldAndExpensiveFilterCost() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(10.0);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(20.0);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2005, 1, 1));
        animals.add(dog);

        List<AbstractAnimal> expected = new ArrayList<>(List.of(dog));

        assertEquals(expected, animalRepository.findOldAndExpensive(animals));
    }

    @Test
    @DisplayName("findOldAndExpensive, передаётся List из 3 объектов, возвращается List с 1 записью, Фильтр по возрасту + по цене, Позитивный тест")
    void checkFindOldAndExpensiveFilterAge() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fox fox = new Fox();

        fox.setBreed("Шотландская");
        fox.setName("Муся");
        fox.setCost(3.0);
        fox.setCharacter("Весёлая");
        fox.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(fox);

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(25.0);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(LocalDate.now().getYear() - 3, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(20.0);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(dog);

        List<AbstractAnimal> expected = new ArrayList<>(List.of(dog));

        assertEquals(expected, animalRepository.findOldAndExpensive(animals));
    }

    @Test
    @DisplayName("findOldAndExpensive, передаётся List из 3 объектов, возвращается List с без записей, Позитивный тест")
    void checkFindOldAndExpensiveReturnEmpty() {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fox fox = new Fox();

        fox.setBreed("Шотландская");
        fox.setName("Муся");
        fox.setCost(20.0);
        fox.setCharacter("Весёлая");
        fox.setBirthDate(LocalDate.of(LocalDate.now().getYear() - 1, 1, 1));
        animals.add(fox);

        cat.setBreed("Британская");
        cat.setName("Мурка");
        cat.setCost(20.0);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(LocalDate.now().getYear() - 2, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Мухтар");
        dog.setCost(20.0);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(LocalDate.now().getYear() - 4, 1, 1));
        animals.add(dog);

        assertThrows(RuntimeException.class, () -> animalRepository.findOldAndExpensive(animals));
    }

    @Test
    @DisplayName("findMinConstAnimals, передаётся List из 4 объектов, возвращается List с 3 записями, Позитивный тест")
    void checkFindMinConstAnimalsFilterCost() throws InvalidAnimalException {
        List<AbstractAnimal> animals = new ArrayList<>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fox fox = new Fox();
        Shark shark = new Shark();

        fox.setBreed("Шотландская");
        fox.setName("Амур");
        fox.setCost(1.0);
        fox.setCharacter("Весёлая");
        fox.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(fox);

        cat.setBreed("Британская");
        cat.setName("Британ");
        cat.setCost(2.0);
        cat.setCharacter("Игривый");
        cat.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(cat);

        dog.setBreed("Гончая");
        dog.setName("Вихрь");
        dog.setCost(3.0);
        dog.setCharacter("Игривый");
        dog.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(dog);

        shark.setBreed("Лысая");
        shark.setName("Главный");
        shark.setCost(4.0);
        shark.setCharacter("Хитрая");
        shark.setBirthDate(LocalDate.of(2000, 1, 1));
        animals.add(shark);

        List<String> expected = new ArrayList<>(List.of(dog.getName(), cat.getName(), fox.getName()));

        assertEquals(expected, animalRepository.findMinConstAnimals(animals));
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

    @Test
    @DisplayName("findAverageAge, передаётся List<AbstractAnimal> из 2 объектов, 1 объект с null возраста, Негативный тест")
    void checkNullDateFindAverageAge() throws RuntimeException {
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
        dog.setBirthDate(null);
        animals.add(dog);

        assertThrows(RuntimeException.class, () -> animalRepository.findAverageAge(animals));
    }

    @Test
    @DisplayName("findAverageAge, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindAverageAge() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findAverageAge(null));
    }

    @Test
    @DisplayName("findOldAndExpensive, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindOldAndExpensive() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findOldAndExpensive(null));
    }

    @Test
    @DisplayName("findMinConstAnimals, передаваемый объект List<AbstractAnimal> = null, Негативный тест")
    void checkNullListFindMinConstAnimals() {
        assertThrows(InvalidAnimalException.class, () -> animalRepository.findMinConstAnimals(null));
    }
}