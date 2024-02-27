package org.example.animal;

import org.example.animal.enumAnimal.*;

import java.util.Random;

/**
 * Класс сервиса для создания Животных (do-while/for цикл)
 * @autor Самойлов Максим
 * @version 1.1
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания животных циклом for.
     * Выводит в консоль породу/имя/цену/характер животного
     */
    public void createAnimal(int N) {
        Pet pet = new Pet();
        Predator predator = new Predator();

        System.out.println("--------START Создание " + N + " уникальных животных");
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

                System.out.print(i + " | ");
                System.out.print(predator);
            }
        }
        System.out.println("--------END Созданы " + N + " уникальных животных" + "\n");
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

        System.out.println("--------START Создание уникальных животных");
        do {
            switch (i) {
                case 0:
                case 1:
                    System.out.println("--------Создаётся животное класса Cat");
                    cat.setBreed(BreedPet.randomBreedPet());
                    cat.setName(Name.randomName());
                    cat.setCost(cat.cost[rand.nextInt(cat.cost.length)]);
                    cat.setCharacter(CharacterPet.randomCharacterPet());

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

                    System.out.print(i + " | ");
                    System.out.print(dog);
                    break;
            }
            i++;
        } while (i < 10);
        System.out.println("--------END Созданы " + i + " уникальных животных" + "\n");
    }
}