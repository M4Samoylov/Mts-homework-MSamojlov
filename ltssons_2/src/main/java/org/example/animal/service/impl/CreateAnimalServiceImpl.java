package org.example.animal.service.impl;

import org.example.animal.animalStructure.AbstractAnimal;
import org.example.animal.service.CreateAnimalService;
import org.example.animal.enumAnimal.*;
import org.example.animal.animalStructure.pet.Cat;
import org.example.animal.animalStructure.pet.Dog;
import org.example.animal.animalStructure.pet.Pet;
import org.example.animal.animalStructure.predator.Fox;
import org.example.animal.animalStructure.predator.Predator;
import org.example.animal.animalStructure.predator.Shark;
import org.example.animal.animalStructure.predator.Wolf;

import java.util.*;

import static org.example.animal.helpers.RandomLocalDate.getRandomDate;

/**
 * Класс сервиса для создания Животных (do-while/for цикл)
 *
 * @version 1.2
 * @autor Самойлов Максим
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания животных циклом for.
     * @return List<AbstractAnimal>
     */
    public List<AbstractAnimal> createListAnimals(int animalsCount) {
        List<AbstractAnimal> animals = new ArrayList<>();

        for (int i = 0; i < animalsCount; i++) {
            animals.add(generateAnimals(1, 20));
        }

        return animals;
    }

    /**
     * Функция создания животных.
     * @return Map<String, List < AbstractAnimal>>
     */
    public Map<String, List<AbstractAnimal>> createMapAnimals(int animalsCount) {
        Map<String, List<AbstractAnimal>> animals = new HashMap<>();
        List<AbstractAnimal> animalsCat = new ArrayList<>();
        List<AbstractAnimal> animalsDog = new ArrayList<>();
        List<AbstractAnimal> animalsFox = new ArrayList<>();
        List<AbstractAnimal> animalsShark = new ArrayList<>();
        List<AbstractAnimal> animalsWolf = new ArrayList<>();

        List<AbstractAnimal> animalsList = new ArrayList<>();

        for (int i = 0; i < animalsCount; i++) {
            animalsList.add(generateAnimals(1, 20));
        }

        for (AbstractAnimal animal : animalsList) {
            if (animal instanceof Cat) {
                animalsCat.add(animal);
            } else if (animal instanceof Dog) {
                animalsDog.add(animal);
            } else if (animal instanceof Fox) {
                animalsFox.add(animal);
            } else if (animal instanceof Shark) {
                animalsShark.add(animal);
            } else if (animal instanceof Wolf) {
                animalsWolf.add(animal);
            }
        }

        if (!animalsCat.isEmpty()) {
            animals.put(KidsAnimal.CAT.name(), animalsCat);
        }

        if (!animalsDog.isEmpty()) {
            animals.put(KidsAnimal.DOG.name(), animalsDog);
        }

        if (!animalsFox.isEmpty()) {
            animals.put(KidsAnimal.FOX.name(), animalsFox);
        }

        if (!animalsShark.isEmpty()) {
            animals.put(KidsAnimal.SHARK.name(), animalsShark);
        }

        if (!animalsWolf.isEmpty()) {
            animals.put(KidsAnimal.WOLF.name(), animalsWolf);
        }

        return animals;
    }

    /**
     * Функция генерации рандомного животных.
     * @return AbstractAnimal
     */
    private AbstractAnimal generateAnimals(int startCost, int endCost) {
        int randPet = new Random().nextInt(KidsAnimal.values().length - 1);
        KidsAnimal petAnimal = KidsAnimal.values()[randPet];

        AbstractAnimal animal;
        String breed;
        String character;
        switch (petAnimal) {
            case CAT:
                animal = new Cat();
                breed = BreedPet.randomBreedPet();
                character = CharacterPet.randomCharacterPet();
                break;
            case DOG:
                animal = new Dog();
                breed = BreedPet.randomBreedPet();
                character = CharacterPet.randomCharacterPet();
                break;
            case FOX:
                animal = new Fox();
                breed = BreedPredator.randomBreedPredator();
                character = CharacterPredator.randomCharacterPredator();
                break;
            case SHARK:
                animal = new Shark();
                breed = BreedPredator.randomBreedPredator();
                character = CharacterPredator.randomCharacterPredator();
                break;
            case WOLF:
                animal = new Wolf();
                breed = BreedPredator.randomBreedPredator();
                character = CharacterPredator.randomCharacterPredator();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + petAnimal);
        }

        animal.setBreed(breed);
        animal.setName(Name.randomName());
        animal.setCost(getRandomCost(startCost, endCost));
        animal.setCharacter(character);
        animal.setBirthDate(getRandomDate());

        return animal;
    }

    /**
     * Функция генерации рандомной цены животных.
     * @return double
     */
    private double getRandomCost(int start, int end) {
        double rand = new Random().nextDouble();
        return start + (rand * (end - start));
    }

    /**
     * Функция создания животного.
     * Возвращает объект животного
     */
    public AbstractAnimal createPetAnimal(AbstractAnimal abstractAnimal, TypeAnimal animal) {
        Random rand = new Random();
        Pet pet = new Pet();
        Predator predator = new Predator();

        switch (animal) {
            case PET: {
                abstractAnimal.setBreed(BreedPet.randomBreedPet());
                abstractAnimal.setName(Name.randomName());
                abstractAnimal.setCost(pet.cost[rand.nextInt(pet.cost.length)]);
                abstractAnimal.setCharacter(CharacterPet.randomCharacterPet());
                abstractAnimal.setBirthDate(getRandomDate());
                break;
            }
            case PREDATOR: {
                abstractAnimal.setBreed(BreedPredator.randomBreedPredator());
                abstractAnimal.setName(Name.randomName());
                abstractAnimal.setCost(predator.cost[rand.nextInt(predator.cost.length)]);
                abstractAnimal.setCharacter(CharacterPredator.randomCharacterPredator());
                abstractAnimal.setBirthDate(getRandomDate());
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
                pet.setBirthDate(getRandomDate());

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
                predator.setBirthDate(getRandomDate());

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
                    cat.setBirthDate(getRandomDate());

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
                    wolf.setBirthDate(getRandomDate());

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
                    shark.setBirthDate(getRandomDate());

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
                    fox.setBirthDate(getRandomDate());

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
                    dog.setBirthDate(getRandomDate());

                    System.out.print(i + " | ");
                    System.out.print(dog);
                    break;
            }
            i++;
        } while (i < 10);
        System.out.println("<<< END Созданы " + i + " уникальных животных" + "\n");
    }
}