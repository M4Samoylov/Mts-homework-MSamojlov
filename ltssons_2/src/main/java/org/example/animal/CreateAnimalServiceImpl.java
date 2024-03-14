package org.example.animal;

import org.example.animal.enumAnimal.*;
import org.example.animal.pet.Cat;
import org.example.animal.pet.Dog;
import org.example.animal.pet.Pet;
import org.example.animal.predator.Fox;
import org.example.animal.predator.Predator;
import org.example.animal.predator.Shark;
import org.example.animal.predator.Wolf;

import java.util.*;

/**
 * Класс сервиса для создания Животных (do-while/for цикл)
 * @autor Самойлов Максим
 * @version 1.1
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания животных циклом for.
     * Выводит в консоль породу/имя/цену/характер животного
     *
     * @return Map<String, List<Animal>>
     */
    public Map<String, List<Animal>> createMapAnimals(int animalsCount) {
        Map<String, List<Animal>> animals = new HashMap<>();

        List<Animal> animalListPet = new ArrayList<>();
        List<Animal> animalListPredator = new ArrayList<>();

        for (int i = 0; i < animalsCount; i++) {
            double rand = new Random().nextDouble();
            if (i % 2 == 0) {
                double start = 1;
                double end = 10;
                double result = start + (rand * (end - start));

                Pet pet = new Pet();
                pet.setBreed(BreedPet.randomBreedPet());
                pet.setName(Name.randomName());
                pet.setCost(result);
                pet.setCharacter(CharacterPet.randomCharacterPet());
                pet.setBirthDate(pet.getRandomDate());

                animalListPet.add(pet);
            } else {
                double start = 11;
                double end = 20;
                double result = start + (rand * (end - start));

                Predator predator = new Predator();
                predator.setBreed(BreedPredator.randomBreedPredator());
                predator.setName(Name.randomName());
                predator.setCost(result);
                predator.setCharacter(CharacterPredator.randomCharacterPredator());
                predator.setBirthDate(predator.getRandomDate());

                animalListPredator.add(predator);
            }
        }
        animals.put(Pet.class.getSimpleName().toUpperCase(), animalListPet);
        animals.put(Predator.class.getSimpleName().toUpperCase(), animalListPredator);
        return animals;
    }

//    private AbstractAnimal setParams(AbstractAnimal animal) {
//        Predator predator = new Predator();
//        Pet pet = new Pet();
//
//        switch ()
//
//        return ;
//    }

    /**
     * Функция создания животного.
     * Возвращает объект животного
     */
    public AbstractAnimal createPetAnimal(AbstractAnimal abstractAnimal, TypeAnimal animal) {
        Random rand = new Random();
        Pet pet = new Pet();
        Predator predator = new Predator();

        switch (animal){
            case PET: {
                abstractAnimal.setBreed(BreedPet.randomBreedPet());
                abstractAnimal.setName(Name.randomName());
                abstractAnimal.setCost(pet.cost[rand.nextInt(pet.cost.length)]);
                abstractAnimal.setCharacter(CharacterPet.randomCharacterPet());
                abstractAnimal.setBirthDate(pet.getRandomDate());
                break;
            }
            case PREDATOR: {
                abstractAnimal.setBreed(BreedPredator.randomBreedPredator());
                abstractAnimal.setName(Name.randomName());
                abstractAnimal.setCost(predator.cost[rand.nextInt(predator.cost.length)]);
                abstractAnimal.setCharacter(CharacterPredator.randomCharacterPredator());
                abstractAnimal.setBirthDate(predator.getRandomDate());
                break;
            }
            default:
                System.out.println("Передан неизвестный тип животного: " + animal);
        }
        return abstractAnimal;
    }

    /**
     * Функция создания животных циклом for.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    public void createAnimal(int N) {
        Pet pet = new Pet();
        Predator predator = new Predator();

        System.out.println(">>> START Создание " + N + " уникальных животных");
        for (int i = 0; i < N; i++) {
            double rand = new Random().nextDouble();
            if (i % 2 == 0) {
                double start = 1;
                double end = 10;
                double result = start + (rand * (end - start));

                System.out.println("--------Создаётся животное класса Pet");
                pet.setBreed(BreedPet.randomBreedPet());
                pet.setName(Name.randomName());
                pet.setCost(result);
                pet.setCharacter(CharacterPet.randomCharacterPet());
                pet.setBirthDate(pet.getRandomDate());

                System.out.print(i + " | ");
                System.out.print(pet);
            } else {
                double start = 11;
                double end = 20;
                double result = start + (rand * (end - start));

                System.out.println("--------Создаётся животное класса Predator");
                predator.setBreed(BreedPredator.randomBreedPredator());
                predator.setName(Name.randomName());
                predator.setCost(result);
                predator.setCharacter(CharacterPredator.randomCharacterPredator());
                predator.setBirthDate(predator.getRandomDate());

                System.out.print(i + " | ");
                System.out.print(predator);
            }
        }
        System.out.println("<<< END Созданы " + N + " уникальных животных" + "\n");
    }

    /**
     * Функция создания животных циклом do-while.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    @Override
    public void createAnimal() {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Shark shark = new Shark();
        Random rand = new Random();
        int i = 0;

        System.out.println(">>> START Создание уникальных животных");
        do {
            switch (i) {
                case 0:
                case 1:
                    System.out.println("--------Создаётся животное класса Cat");
                    cat.setBreed(BreedPet.randomBreedPet());
                    cat.setName(Name.randomName());
                    cat.setCost(cat.cost[rand.nextInt(cat.cost.length)]);
                    cat.setCharacter(CharacterPet.randomCharacterPet());
                    cat.setBirthDate(cat.getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(cat);
                    break;
                case 2:
                case 3:
                    System.out.println("--------Создаётся животное класса Wolf");
                    wolf.setBreed(BreedPredator.randomBreedPredator());
                    wolf.setName(Name.randomName());
                    wolf.setCost(wolf.cost[rand.nextInt(wolf.cost.length)]);
                    wolf.setCharacter(CharacterPredator.randomCharacterPredator());
                    wolf.setBirthDate(wolf.getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(wolf);
                    break;
                case 4:
                case 5:
                    System.out.println("--------Создаётся животное класса Shark");
                    shark.setBreed(BreedPredator.randomBreedPredator());
                    shark.setName(Name.randomName());
                    shark.setCost(shark.cost[rand.nextInt(shark.cost.length)]);
                    shark.setCharacter(CharacterPredator.randomCharacterPredator());
                    shark.setBirthDate(shark.getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(shark);
                    break;
                case 6:
                case 7:
                    System.out.println("--------Создаётся животное класса Fox");
                    fox.setBreed(BreedPredator.randomBreedPredator());
                    fox.setName(Name.randomName());
                    fox.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    fox.setCharacter(CharacterPredator.randomCharacterPredator());
                    fox.setBirthDate(fox.getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(fox);
                    break;
                case 8:
                case 9:
                    System.out.println("--------Создаётся животное класса Dog");
                    dog.setBreed(BreedPet.randomBreedPet());
                    dog.setName(Name.randomName());
                    dog.setCost(fox.cost[rand.nextInt(fox.cost.length)]);
                    dog.setCharacter(CharacterPet.randomCharacterPet());
                    dog.setBirthDate(dog.getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(dog);
                    break;
            }
            i++;
        } while (i < 10);
        System.out.println("<<< END Созданы " + i + " уникальных животных" + "\n");
    }
}