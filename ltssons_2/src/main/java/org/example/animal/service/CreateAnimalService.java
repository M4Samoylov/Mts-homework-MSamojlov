package org.example.animal.service;

import org.example.animal.enumAnimal.*;
import org.example.animal.animalStructure.pet.Pet;
import org.example.animal.animalStructure.predator.Predator;

import java.util.Random;

import static org.example.animal.helpers.RandomLocalDate.getRandomDate;

/**
 * Класс сервиса для создания Животных (while цикл)
 * @autor Самойлов Максим
 * @version 1.1
 */
public interface CreateAnimalService {

    /**
     * Функция создания животных циклом while.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    default void createAnimal(){
        Pet pet = new Pet();
        Predator predator = new Predator();
        int i = 0;

        System.out.println(">>> START Создание уникальных животных");
        while (i < 10) {
            Random rand = new Random();
            if (i < 5) {
                System.out.println("--------Создаётся животное класса Pet");
                pet.setBreed(BreedPet.randomBreedPet());
                pet.setName(Name.randomName());
                pet.setCost(pet.cost[rand.nextInt(pet.cost.length)]);
                pet.setCharacter(CharacterPet.randomCharacterPet());
                pet.setBirthDate(getRandomDate());

                System.out.print(i + " | ");
                System.out.println(pet);
            } else {
                System.out.println("--------Создаётся животное класса Predator");
                predator.setBreed(BreedPredator.randomBreedPredator());
                predator.setName(Name.randomName());
                predator.setCost(predator.cost[rand.nextInt(predator.cost.length)]);
                predator.setCharacter(CharacterPredator.randomCharacterPredator());
                predator.setBirthDate(getRandomDate());

                System.out.print(i + " | ");
                System.out.println(predator);
            }
            i++;
        }
        System.out.println("<<< END Созданы " + i + " уникальных животных" + "\n");
    }
}