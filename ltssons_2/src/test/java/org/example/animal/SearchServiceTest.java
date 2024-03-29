package org.example.animal;

import org.example.animal.Exception.InvalidAnimalBirthDateException;
import org.example.animal.Exception.InvalidAnimalException;
import org.example.animal.enumAnimal.TypeAnimal;
import org.example.animal.animalStructure.pet.Pet;
import org.example.animal.service.impl.CreateAnimalServiceImpl;
import org.example.animal.service.impl.SearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    SearchServiceImpl searchService = new SearchServiceImpl();
    Pet pet = new Pet();

    @BeforeEach
    void setUp() {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        createAnimalServiceImpl.createPetAnimal(pet, TypeAnimal.PET);
    }

    @ParameterizedTest
    @DisplayName("Проверка метода checkLeapYearAnimal, Год високосный, Позитивный тест")
    @ValueSource(ints = {2024, 2020, 2016, 2012, 2008})
    void checkIsLeapYearAnimal(int year) throws InvalidAnimalException {
        pet.setBirthDate(LocalDate.of(year, 1, 1));
        assertTrue(searchService.checkLeapYearAnimal(pet));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода checkLeapYearAnimal, Год невисокосный, Позитивный тест")
    @ValueSource(ints = {2023, 2022, 2021, 2019, 2018})
    void checkNoLeapYearAnimal(int year) throws InvalidAnimalException {
        pet.setBirthDate(LocalDate.of(year, 1, 1));
        assertFalse(searchService.checkLeapYearAnimal(pet));
    }

    @Test
    @DisplayName("Проверка метода checkLeapYearAnimal, BirthDate = null, Негативный тест")
    void checkNullBirthDateAnimal() {
        pet.setBirthDate(null);
        assertThrows(InvalidAnimalBirthDateException.class, () -> searchService.checkLeapYearAnimal(pet));
    }

    @Test
    @DisplayName("Проверка метода checkLeapYearAnimal, передаваемый объект abstractAnimal = null, Негативный тест")
    void checkNullAnimal() {
        assertThrows(InvalidAnimalException.class, () -> searchService.checkLeapYearAnimal(null));
    }
}